package masterball.console.error;

public class UnknownArgument extends ConsoleError {

    public UnknownArgument(String argument) {
        super("unknown argument \"" + argument + "\"");
    }

}
