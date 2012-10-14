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
    private Register register1;
    private Register register2;
    private Register register3;
    private Register accu;
    private Register commandRegister;

    private Memory programMemory;
    private Memory dataMemory;

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
        programMemory = new ProgramMemory();
        dataMemory = new DataMemory();

        // Misc
        commandCounter = 0;

    }


    // Methods
    public void addCommandToProgramMemory(String instructionNr, Instruction command) {
        programMemory.storeCommand(instructionNr, command);
    }

    public HashMap<String, Instruction> getProgramMemory() {
        return programMemory.getProgramMemory();
    }

    public void addCommandToDataMemory(String dataNr, String data) {
        dataMemory.storeData(dataNr, data);
    }
}
