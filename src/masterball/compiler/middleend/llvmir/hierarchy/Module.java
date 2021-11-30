package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.type.ClassType;

import java.util.ArrayList;
import java.util.HashMap;

public class Module {
    public ArrayList<Function> functions = new ArrayList<>();
    public ArrayList<GlobalVariable> globalVars = new ArrayList<>();
    public ArrayList<ClassType> classes = new ArrayList<>();
}
