package masterball.console;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public static class Setting {
        String argName;
        String argValueStr;
        boolean needValue;

        Object argValue;
        Object defaultValue;

        public Setting(String argName, boolean needValue, Object defaultValue) {
            this.argName = argName;
            this.needValue = needValue;
            this.argValue = defaultValue;
            this.defaultValue = defaultValue;
        }
    }

    public enum Option {Version, Help, Input, LogOutput, ASTOutput, IROutput, OptOutput, ASMOutput, FSyntaxOnly, IROnly, Optimize, Wall, OJMode};

    public static Map<Option, Setting> argSetting = new HashMap<>();

    static {
        argSetting.put(Option.Version, new Setting("-v", false, false));
        argSetting.put(Option.Help, new Setting("-h", false, false));

        argSetting.put(Option.Input, new Setting("-i", true, System.in));
        argSetting.put(Option.LogOutput, new Setting("-log-o", true, System.out));
        argSetting.put(Option.ASTOutput, new Setting("-ast-o", true, System.out));
        argSetting.put(Option.IROutput, new Setting("-ir-o", true, System.out));
        argSetting.put(Option.OptOutput, new Setting("-opt-o", true, System.out));
        argSetting.put(Option.ASMOutput, new Setting("-asm-o", true, System.out));

        argSetting.put(Option.FSyntaxOnly, new Setting("-fsyntax-only", false, false));
        argSetting.put(Option.IROnly, new Setting("-ir-only", false, false));

        argSetting.put(Option.Optimize, new Setting("-O2", false, false));
        argSetting.put(Option.Wall, new Setting("-Wall", false, false));
        argSetting.put(Option.OJMode, new Setting("-oj", false, false));
    }

    public static String getPath(Option option) {
        var setting = argSetting.get(option);
        assert setting.needValue;
        return setting.argValueStr;
    }

    public static Object getArgValue(Option option) {
        var setting = argSetting.get(option);
        assert setting.needValue;
        return setting.argValue;
    }
}
