package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:50
 */
public class CPU {

    // Instance Variables
    private static Register register1;
    private static Register register2;
    private static Register register3;
    private static Register accu;
    private static Register commandRegister;

    private static Memory programMemory;
    private static Memory dataMemory;

    private int commandCounter;


    /**
     * Constructor
     */
    public CPU() {
        // Initialize Registers
        register1 = new Register();
        register2 = new Register();
        register3 = new Register();
        accu = new Accumulator();
        commandRegister = new InstructionRegister();

        // Initialize Memory
        programMemory = new Memory();
        dataMemory = new Memory();

        // Misc
        commandCounter = 0;

    }

    // Getter & Setter
    public static Memory getDataMemory() {
        return dataMemory;
    }

    public HashMap<String, Instruction> getProgramMemory() {
        return programMemory.getProgramMemory();
    }

    public static Register getAccu() {
        return accu;
    }

    public static Register getRegister1() {
        return register1;
    }

    public static Register getRegister2() {
        return register2;
    }

    public static Register getRegister3() {
        return register3;
    }

    // Methods
    public void addCommandToMemory(String instructionNr, Instruction command) {
        programMemory.storeCommand(instructionNr, command);
    }

    public void addCommandToMemory(String dataNr, String data) {
        dataMemory.storeCommand(dataNr, data);
    }

}
