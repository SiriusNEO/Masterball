// Generated from ../src/darksword/interpreter/generated/LLVMIR.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLVMIRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, IntType=51, VoidType=52, 
		LabelType=53, GlobalReg=54, LocalReg=55, IntegerLiteral=56, Identifier=57, 
		WhitespaceEater=58, NewlineEater=59, LineCommentEater=60, EscapeEnter=61, 
		EscapeBackslash=62, EscapeQuote=63, StringLiteral=64, NullptrConstant=65, 
		BoolConstant=66, InfoStr=67;
	public static final int
		RULE_llvmIR = 0, RULE_targetInfo = 1, RULE_sourceFn = 2, RULE_dataLayout = 3, 
		RULE_targetTriple = 4, RULE_funcHeader = 5, RULE_funcDecl = 6, RULE_funcDef = 7, 
		RULE_basicBlock = 8, RULE_instDest = 9, RULE_phiBranch = 10, RULE_instruction = 11, 
		RULE_atom = 12, RULE_align = 13, RULE_type = 14, RULE_arrayType = 15, 
		RULE_basicType = 16, RULE_integerConstant = 17, RULE_stringConstant = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"llvmIR", "targetInfo", "sourceFn", "dataLayout", "targetTriple", "funcHeader", 
			"funcDecl", "funcDef", "basicBlock", "instDest", "phiBranch", "instruction", 
			"atom", "align", "type", "arrayType", "basicType", "integerConstant", 
			"stringConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'source_filename'", "'='", "'target'", "'datalayout'", "'triple'", 
			"'('", "','", "')'", "'declare'", "'define'", "'{'", "'}'", "':'", "'['", 
			"']'", "'alloca'", "'add'", "'sub'", "'mul'", "'sdiv'", "'srem'", "'shl'", 
			"'ashr'", "'and'", "'or'", "'xor'", "'bitcast'", "'to'", "'trunc'", "'zext'", 
			"'br'", "'call'", "'getelementptr'", "'icmp'", "'sgt'", "'sge'", "'slt'", 
			"'sle'", "'eq'", "'ne'", "'load'", "'store'", "'ret'", "'phi'", "'align'", 
			"'*'", "'x'", "'-'", "'c\"'", "'\\00\"'", null, "'void'", "'label'", 
			null, null, null, null, null, null, null, "'\\n'", "'\\\\'", "'\\\"'", 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IntType", "VoidType", "LabelType", "GlobalReg", "LocalReg", 
			"IntegerLiteral", "Identifier", "WhitespaceEater", "NewlineEater", "LineCommentEater", 
			"EscapeEnter", "EscapeBackslash", "EscapeQuote", "StringLiteral", "NullptrConstant", 
			"BoolConstant", "InfoStr"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LLVMIR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LLVMIRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LlvmIRContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LLVMIRParser.EOF, 0); }
		public List<TargetInfoContext> targetInfo() {
			return getRuleContexts(TargetInfoContext.class);
		}
		public TargetInfoContext targetInfo(int i) {
			return getRuleContext(TargetInfoContext.class,i);
		}
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public LlvmIRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llvmIR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterLlvmIR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitLlvmIR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitLlvmIR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlvmIRContext llvmIR() throws RecognitionException {
		LlvmIRContext _localctx = new LlvmIRContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_llvmIR);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				setState(41);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
					{
					setState(38);
					targetInfo();
					}
					break;
				case T__8:
					{
					setState(39);
					funcDecl();
					}
					break;
				case T__9:
					{
					setState(40);
					funcDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetInfoContext extends ParserRuleContext {
		public SourceFnContext sourceFn() {
			return getRuleContext(SourceFnContext.class,0);
		}
		public DataLayoutContext dataLayout() {
			return getRuleContext(DataLayoutContext.class,0);
		}
		public TargetTripleContext targetTriple() {
			return getRuleContext(TargetTripleContext.class,0);
		}
		public TargetInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterTargetInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitTargetInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitTargetInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetInfoContext targetInfo() throws RecognitionException {
		TargetInfoContext _localctx = new TargetInfoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_targetInfo);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				sourceFn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				dataLayout();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				targetTriple();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceFnContext extends ParserRuleContext {
		public TerminalNode InfoStr() { return getToken(LLVMIRParser.InfoStr, 0); }
		public SourceFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterSourceFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitSourceFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitSourceFn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceFnContext sourceFn() throws RecognitionException {
		SourceFnContext _localctx = new SourceFnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sourceFn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			match(T__1);
			setState(55);
			match(InfoStr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataLayoutContext extends ParserRuleContext {
		public TerminalNode InfoStr() { return getToken(LLVMIRParser.InfoStr, 0); }
		public DataLayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataLayout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterDataLayout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitDataLayout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitDataLayout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataLayoutContext dataLayout() throws RecognitionException {
		DataLayoutContext _localctx = new DataLayoutContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dataLayout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__2);
			setState(58);
			match(T__3);
			setState(59);
			match(T__1);
			setState(60);
			match(InfoStr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetTripleContext extends ParserRuleContext {
		public TerminalNode InfoStr() { return getToken(LLVMIRParser.InfoStr, 0); }
		public TargetTripleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetTriple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterTargetTriple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitTargetTriple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitTargetTriple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetTripleContext targetTriple() throws RecognitionException {
		TargetTripleContext _localctx = new TargetTripleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_targetTriple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__2);
			setState(63);
			match(T__4);
			setState(64);
			match(T__1);
			setState(65);
			match(InfoStr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncHeaderContext extends ParserRuleContext {
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> LocalReg() { return getTokens(LLVMIRParser.LocalReg); }
		public TerminalNode LocalReg(int i) {
			return getToken(LLVMIRParser.LocalReg, i);
		}
		public FuncHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncHeaderContext funcHeader() throws RecognitionException {
		FuncHeaderContext _localctx = new FuncHeaderContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(GlobalReg);
			setState(68);
			match(T__5);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << IntType) | (1L << VoidType) | (1L << LabelType) | (1L << LocalReg))) != 0)) {
				{
				setState(69);
				type(0);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LocalReg) {
					{
					setState(70);
					match(LocalReg);
					}
				}

				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(73);
					match(T__6);
					setState(74);
					type(0);
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LocalReg) {
						{
						setState(75);
						match(LocalReg);
						}
					}

					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(85);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncHeaderContext funcHeader() {
			return getRuleContext(FuncHeaderContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__8);
			setState(88);
			type(0);
			setState(89);
			funcHeader();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncHeaderContext funcHeader() {
			return getRuleContext(FuncHeaderContext.class,0);
		}
		public List<BasicBlockContext> basicBlock() {
			return getRuleContexts(BasicBlockContext.class);
		}
		public BasicBlockContext basicBlock(int i) {
			return getRuleContext(BasicBlockContext.class,i);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__9);
			setState(92);
			type(0);
			setState(93);
			funcHeader();
			setState(94);
			match(T__10);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(95);
				basicBlock();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicBlockContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LLVMIRParser.Identifier, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BasicBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBasicBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBasicBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBasicBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicBlockContext basicBlock() throws RecognitionException {
		BasicBlockContext _localctx = new BasicBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_basicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(Identifier);
			setState(104);
			match(T__12);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__41) | (1L << T__42) | (1L << LocalReg))) != 0)) {
				{
				{
				setState(105);
				instruction();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstDestContext extends ParserRuleContext {
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public InstDestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instDest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterInstDest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitInstDest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitInstDest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstDestContext instDest() throws RecognitionException {
		InstDestContext _localctx = new InstDestContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instDest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LocalReg);
			setState(112);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhiBranchContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public PhiBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phiBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterPhiBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitPhiBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitPhiBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhiBranchContext phiBranch() throws RecognitionException {
		PhiBranchContext _localctx = new PhiBranchContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_phiBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__13);
			setState(115);
			atom();
			setState(116);
			match(T__6);
			setState(117);
			atom();
			setState(118);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetContext extends InstructionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public RetContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocaContext extends InstructionContext {
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
		}
		public AllocaContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAlloca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAlloca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAlloca(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetelementptrContext extends InstructionContext {
		public AtomContext src;
		public Token offset;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public GetelementptrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterGetelementptr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitGetelementptr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitGetelementptr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreContext extends InstructionContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
		}
		public StoreContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterStore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitStore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitStore(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitcastContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public BitcastContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBitcast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBitcast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBitcast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IcmpContext extends InstructionContext {
		public Token cmpOp;
		public AtomContext lsrc;
		public AtomContext rsrc;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public IcmpContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterIcmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitIcmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitIcmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BrContext extends InstructionContext {
		public AtomContext src;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public BrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallContext extends InstructionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncHeaderContext funcHeader() {
			return getRuleContext(FuncHeaderContext.class,0);
		}
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public CallContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PhiContext extends InstructionContext {
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<PhiBranchContext> phiBranch() {
			return getRuleContexts(PhiBranchContext.class);
		}
		public PhiBranchContext phiBranch(int i) {
			return getRuleContext(PhiBranchContext.class,i);
		}
		public PhiContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterPhi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitPhi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitPhi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TruncContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TruncContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterTrunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitTrunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitTrunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadContext extends InstructionContext {
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
		}
		public LoadContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends InstructionContext {
		public Token binaryOp;
		public AtomContext lsrc;
		public AtomContext rsrc;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public BinaryContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ZextContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ZextContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterZext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitZext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitZext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_instruction);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new AllocaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				instDest();
				setState(121);
				match(T__15);
				setState(122);
				type(0);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(123);
					match(T__6);
					setState(124);
					align();
					}
				}

				}
				break;
			case 2:
				_localctx = new BinaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				instDest();
				setState(138);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__16:
					{
					setState(128);
					((BinaryContext)_localctx).binaryOp = match(T__16);
					}
					break;
				case T__17:
					{
					setState(129);
					match(T__17);
					}
					break;
				case T__18:
					{
					setState(130);
					match(T__18);
					}
					break;
				case T__19:
					{
					setState(131);
					match(T__19);
					}
					break;
				case T__20:
					{
					setState(132);
					match(T__20);
					}
					break;
				case T__21:
					{
					setState(133);
					match(T__21);
					}
					break;
				case T__22:
					{
					setState(134);
					match(T__22);
					}
					break;
				case T__23:
					{
					setState(135);
					match(T__23);
					}
					break;
				case T__24:
					{
					setState(136);
					match(T__24);
					}
					break;
				case T__25:
					{
					setState(137);
					match(T__25);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(140);
				type(0);
				{
				setState(141);
				((BinaryContext)_localctx).lsrc = atom();
				}
				setState(142);
				match(T__6);
				{
				setState(143);
				((BinaryContext)_localctx).rsrc = atom();
				}
				}
				break;
			case 3:
				_localctx = new BitcastContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				instDest();
				setState(146);
				match(T__1);
				setState(147);
				match(T__26);
				setState(148);
				type(0);
				{
				setState(149);
				((BitcastContext)_localctx).src = atom();
				}
				setState(150);
				match(T__27);
				setState(151);
				type(0);
				}
				break;
			case 4:
				_localctx = new TruncContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				instDest();
				setState(154);
				match(T__28);
				setState(155);
				type(0);
				{
				setState(156);
				((TruncContext)_localctx).src = atom();
				}
				setState(157);
				match(T__27);
				setState(158);
				type(0);
				}
				break;
			case 5:
				_localctx = new ZextContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(160);
				instDest();
				setState(161);
				match(T__29);
				setState(162);
				type(0);
				{
				setState(163);
				((ZextContext)_localctx).src = atom();
				}
				setState(164);
				match(T__27);
				setState(165);
				type(0);
				}
				break;
			case 6:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				match(T__30);
				setState(168);
				type(0);
				setState(169);
				atom();
				}
				break;
			case 7:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				match(T__30);
				setState(172);
				type(0);
				{
				setState(173);
				((BrContext)_localctx).src = atom();
				}
				setState(174);
				match(T__6);
				setState(175);
				type(0);
				setState(176);
				atom();
				setState(177);
				match(T__6);
				setState(178);
				type(0);
				setState(179);
				atom();
				}
				break;
			case 8:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LocalReg) {
					{
					setState(181);
					instDest();
					}
				}

				setState(184);
				match(T__31);
				setState(185);
				type(0);
				setState(186);
				funcHeader();
				}
				break;
			case 9:
				_localctx = new GetelementptrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(188);
				instDest();
				setState(189);
				match(T__32);
				setState(190);
				type(0);
				setState(191);
				match(T__6);
				setState(192);
				type(0);
				{
				setState(193);
				((GetelementptrContext)_localctx).src = atom();
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(194);
					((GetelementptrContext)_localctx).offset = match(T__6);
					setState(195);
					type(0);
					setState(196);
					atom();
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 10:
				_localctx = new IcmpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				instDest();
				setState(204);
				match(T__33);
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__34:
					{
					setState(205);
					((IcmpContext)_localctx).cmpOp = match(T__34);
					}
					break;
				case T__35:
					{
					setState(206);
					match(T__35);
					}
					break;
				case T__36:
					{
					setState(207);
					match(T__36);
					}
					break;
				case T__37:
					{
					setState(208);
					match(T__37);
					}
					break;
				case T__38:
					{
					setState(209);
					match(T__38);
					}
					break;
				case T__39:
					{
					setState(210);
					match(T__39);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213);
				type(0);
				{
				setState(214);
				((IcmpContext)_localctx).lsrc = atom();
				}
				{
				setState(215);
				((IcmpContext)_localctx).rsrc = atom();
				}
				}
				break;
			case 11:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(217);
				instDest();
				setState(218);
				match(T__40);
				setState(219);
				type(0);
				setState(220);
				match(T__6);
				setState(221);
				type(0);
				setState(222);
				atom();
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(223);
					match(T__6);
					setState(224);
					align();
					}
				}

				}
				break;
			case 12:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(227);
				match(T__41);
				setState(228);
				type(0);
				setState(229);
				atom();
				setState(230);
				match(T__6);
				setState(231);
				type(0);
				setState(232);
				atom();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(233);
					match(T__6);
					setState(234);
					align();
					}
				}

				}
				break;
			case 13:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(237);
				match(T__42);
				setState(238);
				type(0);
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(239);
					atom();
					}
					break;
				}
				}
				break;
			case 14:
				_localctx = new PhiContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(242);
				instDest();
				setState(243);
				match(T__43);
				setState(244);
				type(0);
				setState(245);
				phiBranch();
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(246);
					match(T__6);
					setState(247);
					phiBranch();
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public IntegerConstantContext integerConstant() {
			return getRuleContext(IntegerConstantContext.class,0);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public TerminalNode NullptrConstant() { return getToken(LLVMIRParser.NullptrConstant, 0); }
		public TerminalNode BoolConstant() { return getToken(LLVMIRParser.BoolConstant, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GlobalReg:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(GlobalReg);
				}
				break;
			case LocalReg:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(LocalReg);
				}
				break;
			case T__47:
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				integerConstant();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 4);
				{
				setState(258);
				stringConstant();
				}
				break;
			case NullptrConstant:
				enterOuterAlt(_localctx, 5);
				{
				setState(259);
				match(NullptrConstant);
				}
				break;
			case BoolConstant:
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
				match(BoolConstant);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public AlignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_align; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAlign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAlign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAlign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlignContext align() throws RecognitionException {
		AlignContext _localctx = new AlignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_align);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__44);
			setState(264);
			match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case VoidType:
			case LabelType:
			case LocalReg:
				{
				setState(267);
				basicType();
				}
				break;
			case T__13:
				{
				setState(268);
				arrayType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(271);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(272);
					match(T__45);
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__13);
			setState(279);
			match(IntegerLiteral);
			setState(280);
			match(T__46);
			setState(281);
			type(0);
			setState(282);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(LLVMIRParser.IntType, 0); }
		public TerminalNode VoidType() { return getToken(LLVMIRParser.VoidType, 0); }
		public TerminalNode LabelType() { return getToken(LLVMIRParser.LabelType, 0); }
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << VoidType) | (1L << LabelType) | (1L << LocalReg))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerConstantContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public IntegerConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterIntegerConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitIntegerConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitIntegerConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerConstantContext integerConstant() throws RecognitionException {
		IntegerConstantContext _localctx = new IntegerConstantContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_integerConstant);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(IntegerLiteral);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(T__47);
				setState(288);
				match(IntegerLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringConstantContext extends ParserRuleContext {
		public List<TerminalNode> EscapeEnter() { return getTokens(LLVMIRParser.EscapeEnter); }
		public TerminalNode EscapeEnter(int i) {
			return getToken(LLVMIRParser.EscapeEnter, i);
		}
		public List<TerminalNode> EscapeBackslash() { return getTokens(LLVMIRParser.EscapeBackslash); }
		public TerminalNode EscapeBackslash(int i) {
			return getToken(LLVMIRParser.EscapeBackslash, i);
		}
		public List<TerminalNode> EscapeQuote() { return getTokens(LLVMIRParser.EscapeQuote); }
		public TerminalNode EscapeQuote(int i) {
			return getToken(LLVMIRParser.EscapeQuote, i);
		}
		public List<TerminalNode> StringLiteral() { return getTokens(LLVMIRParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(LLVMIRParser.StringLiteral, i);
		}
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stringConstant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__48);
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(292);
					_la = _input.LA(1);
					if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (EscapeEnter - 61)) | (1L << (EscapeBackslash - 61)) | (1L << (EscapeQuote - 61)) | (1L << (StringLiteral - 61)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(298);
			match(T__49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u012f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\5\7J\n\7\3\7\3\7\3\7\5\7O\n\7\7\7Q\n\7\f\7\16\7T"+
		"\13\7\5\7V\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tc\n\t\f"+
		"\t\16\tf\13\t\3\t\3\t\3\n\3\n\3\n\7\nm\n\n\f\n\16\np\13\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u0080\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008d\n\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u00b9\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u00c9\n\r\f\r\16\r\u00cc\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00d6\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00e4\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ee\n\r\3\r\3\r\3\r\5"+
		"\r\u00f3\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00fb\n\r\f\r\16\r\u00fe\13\r"+
		"\5\r\u0100\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0108\n\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\5\20\u0110\n\20\3\20\3\20\7\20\u0114\n\20\f\20\16"+
		"\20\u0117\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\5\23\u0124\n\23\3\24\3\24\7\24\u0128\n\24\f\24\16\24\u012b\13\24\3\24"+
		"\3\24\3\24\3\u0129\3\36\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&\2\4\4\2\65\6799\3\2?B\2\u0151\2-\3\2\2\2\4\65\3\2\2\2\6\67\3\2\2\2\b"+
		";\3\2\2\2\n@\3\2\2\2\fE\3\2\2\2\16Y\3\2\2\2\20]\3\2\2\2\22i\3\2\2\2\24"+
		"q\3\2\2\2\26t\3\2\2\2\30\u00ff\3\2\2\2\32\u0107\3\2\2\2\34\u0109\3\2\2"+
		"\2\36\u010f\3\2\2\2 \u0118\3\2\2\2\"\u011e\3\2\2\2$\u0123\3\2\2\2&\u0125"+
		"\3\2\2\2(,\5\4\3\2),\5\16\b\2*,\5\20\t\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2"+
		",/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3\61"+
		"\3\3\2\2\2\62\66\5\6\4\2\63\66\5\b\5\2\64\66\5\n\6\2\65\62\3\2\2\2\65"+
		"\63\3\2\2\2\65\64\3\2\2\2\66\5\3\2\2\2\678\7\3\2\289\7\4\2\29:\7E\2\2"+
		":\7\3\2\2\2;<\7\5\2\2<=\7\6\2\2=>\7\4\2\2>?\7E\2\2?\t\3\2\2\2@A\7\5\2"+
		"\2AB\7\7\2\2BC\7\4\2\2CD\7E\2\2D\13\3\2\2\2EF\78\2\2FU\7\b\2\2GI\5\36"+
		"\20\2HJ\79\2\2IH\3\2\2\2IJ\3\2\2\2JR\3\2\2\2KL\7\t\2\2LN\5\36\20\2MO\7"+
		"9\2\2NM\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PK\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3"+
		"\2\2\2SV\3\2\2\2TR\3\2\2\2UG\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\n\2\2X\r"+
		"\3\2\2\2YZ\7\13\2\2Z[\5\36\20\2[\\\5\f\7\2\\\17\3\2\2\2]^\7\f\2\2^_\5"+
		"\36\20\2_`\5\f\7\2`d\7\r\2\2ac\5\22\n\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2"+
		"de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\16\2\2h\21\3\2\2\2ij\7;\2\2jn\7\17"+
		"\2\2km\5\30\r\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\23\3\2\2\2pn"+
		"\3\2\2\2qr\79\2\2rs\7\4\2\2s\25\3\2\2\2tu\7\20\2\2uv\5\32\16\2vw\7\t\2"+
		"\2wx\5\32\16\2xy\7\21\2\2y\27\3\2\2\2z{\5\24\13\2{|\7\22\2\2|\177\5\36"+
		"\20\2}~\7\t\2\2~\u0080\5\34\17\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0100\3\2\2\2\u0081\u008c\5\24\13\2\u0082\u008d\7\23\2\2\u0083\u008d"+
		"\7\24\2\2\u0084\u008d\7\25\2\2\u0085\u008d\7\26\2\2\u0086\u008d\7\27\2"+
		"\2\u0087\u008d\7\30\2\2\u0088\u008d\7\31\2\2\u0089\u008d\7\32\2\2\u008a"+
		"\u008d\7\33\2\2\u008b\u008d\7\34\2\2\u008c\u0082\3\2\2\2\u008c\u0083\3"+
		"\2\2\2\u008c\u0084\3\2\2\2\u008c\u0085\3\2\2\2\u008c\u0086\3\2\2\2\u008c"+
		"\u0087\3\2\2\2\u008c\u0088\3\2\2\2\u008c\u0089\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\5\36\20\2\u008f"+
		"\u0090\5\32\16\2\u0090\u0091\7\t\2\2\u0091\u0092\5\32\16\2\u0092\u0100"+
		"\3\2\2\2\u0093\u0094\5\24\13\2\u0094\u0095\7\4\2\2\u0095\u0096\7\35\2"+
		"\2\u0096\u0097\5\36\20\2\u0097\u0098\5\32\16\2\u0098\u0099\7\36\2\2\u0099"+
		"\u009a\5\36\20\2\u009a\u0100\3\2\2\2\u009b\u009c\5\24\13\2\u009c\u009d"+
		"\7\37\2\2\u009d\u009e\5\36\20\2\u009e\u009f\5\32\16\2\u009f\u00a0\7\36"+
		"\2\2\u00a0\u00a1\5\36\20\2\u00a1\u0100\3\2\2\2\u00a2\u00a3\5\24\13\2\u00a3"+
		"\u00a4\7 \2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6\5\32\16\2\u00a6\u00a7"+
		"\7\36\2\2\u00a7\u00a8\5\36\20\2\u00a8\u0100\3\2\2\2\u00a9\u00aa\7!\2\2"+
		"\u00aa\u00ab\5\36\20\2\u00ab\u00ac\5\32\16\2\u00ac\u0100\3\2\2\2\u00ad"+
		"\u00ae\7!\2\2\u00ae\u00af\5\36\20\2\u00af\u00b0\5\32\16\2\u00b0\u00b1"+
		"\7\t\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\5\32\16\2\u00b3\u00b4\7\t\2"+
		"\2\u00b4\u00b5\5\36\20\2\u00b5\u00b6\5\32\16\2\u00b6\u0100\3\2\2\2\u00b7"+
		"\u00b9\5\24\13\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3"+
		"\2\2\2\u00ba\u00bb\7\"\2\2\u00bb\u00bc\5\36\20\2\u00bc\u00bd\5\f\7\2\u00bd"+
		"\u0100\3\2\2\2\u00be\u00bf\5\24\13\2\u00bf\u00c0\7#\2\2\u00c0\u00c1\5"+
		"\36\20\2\u00c1\u00c2\7\t\2\2\u00c2\u00c3\5\36\20\2\u00c3\u00ca\5\32\16"+
		"\2\u00c4\u00c5\7\t\2\2\u00c5\u00c6\5\36\20\2\u00c6\u00c7\5\32\16\2\u00c7"+
		"\u00c9\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u0100\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00ce\5\24\13\2\u00ce\u00d5\7$\2\2\u00cf\u00d6\7%\2\2\u00d0\u00d6\7&"+
		"\2\2\u00d1\u00d6\7\'\2\2\u00d2\u00d6\7(\2\2\u00d3\u00d6\7)\2\2\u00d4\u00d6"+
		"\7*\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5"+
		"\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d8\5\36\20\2\u00d8\u00d9\5\32\16\2\u00d9\u00da\5\32\16\2"+
		"\u00da\u0100\3\2\2\2\u00db\u00dc\5\24\13\2\u00dc\u00dd\7+\2\2\u00dd\u00de"+
		"\5\36\20\2\u00de\u00df\7\t\2\2\u00df\u00e0\5\36\20\2\u00e0\u00e3\5\32"+
		"\16\2\u00e1\u00e2\7\t\2\2\u00e2\u00e4\5\34\17\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u0100\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6\u00e7\5\36"+
		"\20\2\u00e7\u00e8\5\32\16\2\u00e8\u00e9\7\t\2\2\u00e9\u00ea\5\36\20\2"+
		"\u00ea\u00ed\5\32\16\2\u00eb\u00ec\7\t\2\2\u00ec\u00ee\5\34\17\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u0100\3\2\2\2\u00ef\u00f0\7-"+
		"\2\2\u00f0\u00f2\5\36\20\2\u00f1\u00f3\5\32\16\2\u00f2\u00f1\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u0100\3\2\2\2\u00f4\u00f5\5\24\13\2\u00f5\u00f6\7"+
		".\2\2\u00f6\u00f7\5\36\20\2\u00f7\u00fc\5\26\f\2\u00f8\u00f9\7\t\2\2\u00f9"+
		"\u00fb\5\26\f\2\u00fa\u00f8\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3"+
		"\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"z\3\2\2\2\u00ff\u0081\3\2\2\2\u00ff\u0093\3\2\2\2\u00ff\u009b\3\2\2\2"+
		"\u00ff\u00a2\3\2\2\2\u00ff\u00a9\3\2\2\2\u00ff\u00ad\3\2\2\2\u00ff\u00b8"+
		"\3\2\2\2\u00ff\u00be\3\2\2\2\u00ff\u00cd\3\2\2\2\u00ff\u00db\3\2\2\2\u00ff"+
		"\u00e5\3\2\2\2\u00ff\u00ef\3\2\2\2\u00ff\u00f4\3\2\2\2\u0100\31\3\2\2"+
		"\2\u0101\u0108\78\2\2\u0102\u0108\79\2\2\u0103\u0108\5$\23\2\u0104\u0108"+
		"\5&\24\2\u0105\u0108\7C\2\2\u0106\u0108\7D\2\2\u0107\u0101\3\2\2\2\u0107"+
		"\u0102\3\2\2\2\u0107\u0103\3\2\2\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0106\3\2\2\2\u0108\33\3\2\2\2\u0109\u010a\7/\2\2\u010a\u010b"+
		"\7:\2\2\u010b\35\3\2\2\2\u010c\u010d\b\20\1\2\u010d\u0110\5\"\22\2\u010e"+
		"\u0110\5 \21\2\u010f\u010c\3\2\2\2\u010f\u010e\3\2\2\2\u0110\u0115\3\2"+
		"\2\2\u0111\u0112\f\5\2\2\u0112\u0114\7\60\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\37\3\2\2"+
		"\2\u0117\u0115\3\2\2\2\u0118\u0119\7\20\2\2\u0119\u011a\7:\2\2\u011a\u011b"+
		"\7\61\2\2\u011b\u011c\5\36\20\2\u011c\u011d\7\21\2\2\u011d!\3\2\2\2\u011e"+
		"\u011f\t\2\2\2\u011f#\3\2\2\2\u0120\u0124\7:\2\2\u0121\u0122\7\62\2\2"+
		"\u0122\u0124\7:\2\2\u0123\u0120\3\2\2\2\u0123\u0121\3\2\2\2\u0124%\3\2"+
		"\2\2\u0125\u0129\7\63\2\2\u0126\u0128\t\3\2\2\u0127\u0126\3\2\2\2\u0128"+
		"\u012b\3\2\2\2\u0129\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012c\3\2"+
		"\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7\64\2\2\u012d\'\3\2\2\2\32+-\65"+
		"INRUdn\177\u008c\u00b8\u00ca\u00d5\u00e3\u00ed\u00f2\u00fc\u00ff\u0107"+
		"\u010f\u0115\u0123\u0129";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}