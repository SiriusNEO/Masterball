# Register Allocation

Reference: @Tiger Book



寄存器分配的目的：

- 将大量临时变量分配到物理寄存器中。
- 对于 move 指令，给其 src 和 dest 分配同一个寄存器。


## Liveness Analyzer

#### 活跃分析
维护出每个 block 的 use 和 def，然后构建冲突图，冲突图中的边表示两个变量有重叠部分。
寄存器分配就分配到一个储存了已死的值的寄存器上即可。注意冲突图上有边的两个变量不能分配相同寄存器。

#### 约定

这里为了方便，我们对 block 做活跃分析，因此下面的节点均为一个 block。对于每个节点，我们维护如下信息：

- use: 一个节点中被使用的变量
- def: 被赋值的节点，即变量的定义
- live: 表示这个变量的值将来还要继续使用。在一个边上活跃，指存在一条从这条边通向一个 use 且不经过任何 def 的有向路径。（即保持当前的值直到被下一次使用）
- liveIn: 入口活跃，一个变量在此节点的所有入边都活跃
- liveOut: 出口活跃，在此节点的某个出边活跃

这里的变量也即虚拟寄存器。

生命周期（live范围）：从一个 def 开始，到最远的 use 结束。中间没有其它 def。

#### 求解

活跃信息（liveIn 和 liveOut）可以通过 use 和 def 求出。

$$in[n]=use[n] \cup (out[n] - def[n])$$
$$out[n] = \bigcup_{s \in succ[n]} in[s]$$

边界条件：$$ in[exit] = empty $$

**解释**

- use[n] 都是 in[n]。因为入边都指向自己。
-  如果一个变量在节点 n 是 in，那么它在所有的 pred[n] 上都是 out。因为在 pred[n] 它走一条出边到达 n，肯定从某个入边进来，而这个入边又是活跃的，所以出边肯定也活跃。换一种理解方式，如果在 n 是出口活跃的，那么一定有一个后继节点是入口活跃的。
-  如果一个变量在节点 n 是 out 且不属于 def[n]，那么它属于 in[n]。这是因为如果此节点没有 def，那么入边就可以从出边离开，而出边都是活跃的，那么入边肯定也都是活跃的。
-  程序结束所有变量肯定都死了（不可能再有下次使用）

## Build

建立冲突图。冲突图最常见的就是两个变量同时活跃。

#### 连边方式

之前我们维护的是 block 的信息。现在我们需要推出 inst 的 liveIn 和 liveOut。inst 一定是顺序的（一个前驱，一个后继），由于后面连边我们只用到 liveOut，所以这里就只求 liveOut。最后一个 inst 的 liveOut 就是 block 的 liveOut。然后前一个 inst 的 liveOut 是这一个基础上扣掉 def，加上 use。

连边：所有 def （代表一段生命周期）向此时存活的其它寄存器连边（双向，因为是关系），表示此 def（左端点）被覆盖到了。此时存活的包括这时刻的所有 def	（同时开始活跃） 和 liveOut（活跃到现在）


## Simplify

简化冲突图。这一步是为了删除低度数（< K）的点。

删掉这边采用放到 selectStack 的方式表示。每次从 worklist 中删一个。这些删掉的节点同时也是能够被染色的节点，等待 assignColor 阶段被染色。


## Coalesce

合并传送指令。两个寄存器可以合并当且仅当它们之间无边并且它们由一个 Move 指令相连（src 和 dest）。
注意，并不是所有符合上述条件的都直接合并，因为合并完之后图可能从可着色变为不可着色（从而造成溢出，这样并不优）。

两种原则：

- Briggs：合并后产生的节点高度数（大等于K）邻节点个数<K。因为简化会将这个合并后的节点移走。
- George：a 和 b 可以合并条件是：a 的每一个邻居 t，t 低度数或者 t 与 b 冲突。因为一次简化后 a 的所有邻居都和 b 相邻。 

合并用并查集维护。合并完另一个节点丢到 coalescedNodes 里。

## Freeze

前面提到合并有条件。在 makeWorkList 的时候，move 有关的节点因为有合并的希望暂时不放入简化工作表中。如果无法合并，我们选择一个低度数的传送有关的节点，冻结与其有关的所有传送，即放弃这些传送的合并，使得其在下一轮被简化。

## SelectSpill

选择 spillWorklist 中“代价”最小的一个高度数节点进行溢出。

溢出的节点加入简化工作表等待被删除（虽然它并非低度数节点），等到染色时会区分可染色节点和溢出节点。


## AssignColors

对 selectStack 里的点进行染色（本轮需要染色的节点），如果颜色不够，把当前节点放到已溢出表中。


## Rewrite

先给 spilledStack 里所有的寄存器分配储存单元。

然后给这些寄存器插入对应的 load 和 store。def 后插 store，use 前插 load。

## StackHierachy

三层结构：

- callerArg + 0

- alloca (+ callUse)

- spill (+callUse + allocaUse)
- calleeArg (+totalUse)，对接上层的 callerArg

区分不同层的栈帧存于 Function 中。

func call 部分取 max。

#### RawStackOffset

需要经过处理变成真正的栈位移。

对应层结构有四种状态，分别代表不同 level 的栈位移。