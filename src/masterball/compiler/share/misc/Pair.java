package masterball.compiler.share.misc;

// this implements a simple Pair in java

public class Pair<FirstType, SecondType> {
    public final FirstType first;
    public final SecondType second;

    public Pair(FirstType first, SecondType second) {
        this.first = first;
        this.second = second;
    }
}
