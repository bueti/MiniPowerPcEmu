package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:38
 */
public abstract class Instruction {
    // Constants
    public final static int UPPER_LIMIT = 32767;  // 2^15 - 1
    public final static int LOWER_LIMIT = -32768; // -2^15

    // Instance Vars
    private String parameters;

    // Constructors
    public Instruction() {
    }

    public Instruction(String parameters) {
        this.parameters = parameters;
    }

    // Abstract Methods
    public abstract String convertToOpcode(Memory dataMemory);

    public abstract void doIt(CPU cpu);

    // Methods
    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String convertRegister(int i) {
        String register = null;
        return register.format("%2s", Integer.toBinaryString(i)).replace(' ', '0');
    }

}
