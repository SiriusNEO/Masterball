package masterball.compiler.share.misc;

// this implements a simple Pair in java

public class Pair<FirstType, SecondType> {
    private final FirstType first;
    private final SecondType second;

    public Pair(FirstType first, SecondType second) {
        this.first = first;
        this.second = second;
    }

    public FirstType first() {return first;}
    public SecondType second() {return second;}
}
