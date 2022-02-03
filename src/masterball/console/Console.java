package masterball.console;

import masterball.console.error.NoArgumentValue;
import masterball.console.error.UnknownArgument;
import masterball.debug.Log;

import java.io.*;
import java.util.Objects;

public class Console {

    public String inputPath, logOutputPath, astOutputPath, irOutputPath, asmOutputPath;

    public InputStream inputStream;
    public PrintStream logOutputStream, astOutputStream, irOutputStream, asmOutputStream;

    public boolean showVersion, showHelp, fsyntaxOnly, irOnly, optimize;

    public static String getFileName(String path) {
        if (path == null) return "test";
        for (int i = path.length()-1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                return path.substring(i+1);
            }
        }
        return path;
    }

    private boolean argMatch(String argName) {
        for (var option : Config.argSetting.keySet()) {
            if (Objects.equals(Config.argSetting.get(option).argName, argName)) return true;
        }
        return false;
    }

    private void argParser(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (!argMatch(args[i])) throw new UnknownArgument(args[i]);

            for (var option : Config.argSetting.keySet()) {
                if (Objects.equals(Config.argSetting.get(option).argName, args[i])) {
                    if (Config.argSetting.get(option).needValue) {
                        if (i == args.length - 1) throw new NoArgumentValue(args[i]);

                        i++; // emit the value
                        if (argMatch(args[i])) throw new NoArgumentValue(args[i - 1]);

                        String path = args[i];
                        Config.argSetting.get(option).argValueStr = path;

                        switch (option) {
                            case Input: {
                                Config.argSetting.get(option).argValue = new FileInputStream(path);
                                break;
                            }
                            case LogOutput:
                            case ASTOutput:
                            case IROutput:
                            case ASMOutput: {
                                Config.argSetting.get(option).argValue = new PrintStream(path);
                                break;
                            }
                        }
                    } else {
                        Config.argSetting.get(option).argValue = true;
                    }
                    break;
                }
            }
        }
    }

    private void argMapping() {
         inputPath = Config.argSetting.get(Config.Option.Input).argValueStr;
         inputStream = (InputStream) Config.argSetting.get(Config.Option.Input).argValue;

         logOutputPath = Config.argSetting.get(Config.Option.LogOutput).argValueStr;
         logOutputStream = (PrintStream) Config.argSetting.get(Config.Option.LogOutput).argValue;

         astOutputPath = Config.argSetting.get(Config.Option.ASTOutput).argValueStr;
         astOutputStream = (PrintStream) Config.argSetting.get(Config.Option.ASTOutput).argValue;

         irOutputPath = Config.argSetting.get(Config.Option.IROutput).argValueStr;
         irOutputStream = (PrintStream) Config.argSetting.get(Config.Option.IROutput).argValue;

         asmOutputPath = Config.argSetting.get(Config.Option.ASMOutput).argValueStr;
         asmOutputStream = (PrintStream) Config.argSetting.get(Config.Option.ASMOutput).argValue;

         showHelp = (boolean) Config.argSetting.get(Config.Option.Help).argValue;
         showVersion = (boolean) Config.argSetting.get(Config.Option.Version).argValue;
         fsyntaxOnly = (boolean) Config.argSetting.get(Config.Option.FSyntaxOnly).argValue;
         irOnly = (boolean) Config.argSetting.get(Config.Option.IROnly).argValue;
         optimize = (boolean) Config.argSetting.get(Config.Option.Optimize).argValue;
    }

    public Console(String[] args) throws Exception {
        argParser(args);
        argMapping();

        if (showHelp) {
            System.out.println(CmdDoc.help());
        }

        if (showVersion) {
            System.out.println(CmdDoc.version());
        }

        Log.setPrintStream(logOutputStream);

        Log.track("Console started successfully.");
    }
}