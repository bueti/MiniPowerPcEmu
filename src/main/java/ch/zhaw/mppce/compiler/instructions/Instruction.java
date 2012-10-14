package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Register;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:38
 */
public abstract class Instruction {
    // Instance Vars
    private String parameters;

    // Constructors
    public Instruction() {};

    public Instruction(String parameters) {
        this.parameters = parameters;
    }

    // Abstract Methods
    public abstract String convertToBinary();
    public abstract void doIt(HashMap<String, Instruction> programMemory, HashMap<String, String> dataMemory, Register accu, Register register1, Register register2, Register register3);

    // Methods
    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String convertRegister(int i) {
        String register = null;
        register = register.format("%2s", Integer.toBinaryString(i)).replace(' ', '0');
        return register;
    }

}
