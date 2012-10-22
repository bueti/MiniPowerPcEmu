package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.ArrayList;

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
    private CommandRegister commandRegister;

    private Memory programMemory;
    private Memory dataMemory;

    private int commandPointer;
    private int commandCounter;
    private boolean carryBit;


    /**
     * Constructor
     */
    public CPU() {
        // Initialize Registers
        register1 = new Register();
        register2 = new Register();
        register3 = new Register();
        accu = new Register();
        commandRegister = new CommandRegister();

        // Initialize Memory
        programMemory = new Memory();
        dataMemory = new Memory();

        // Misc
        commandPointer = 100;
        commandCounter = 0;
        carryBit = false;

    }

    // Methods
    public void addCommandToMemory(String instructionNr, Instruction command) {
        programMemory.storeCommand(instructionNr, command);
    }

    public void addCommandToMemory(String dataNr, String data) {
        dataMemory.storeCommand(dataNr, data);
    }

    public void storeToCommandRegister(String command) {
        commandRegister.addCommand(command);
    }

    public void incCommandPointer() {
        commandPointer = commandPointer + 2;
    }

    public void incCommandCounter() {
        commandCounter++;
    }

    public String printRegister1() {
        return register1.getRegister();
    }

    public String printRegister2() {
        return register2.getRegister();
    }

    public String printRegister3() {
        return register3.getRegister();
    }

    public String printAccumulator() {
        return accu.getRegister();
    }

    public void printProgramMemory() {
        programMemory.printProgramMemory();
    }

    public void printDataMemory() {
        dataMemory.printDataMemory();
    }

    // Return the command register as an ArrayList of Strings
    public ArrayList<String> showCommandRegister() {
        return commandRegister.getCommandRegister();
    }

    public void printRegisters() {
        System.out.print("R1: ");
        register1.print();
        System.out.print("R2: ");
        register2.print();
        System.out.print("R3: ");
        register3.print();
    }

    // Getter & Setter
    public Memory getDataMemory() {
        return dataMemory;
    }

    public Memory getProgramMemory() {
        return programMemory;
    }

    public Register getAccu() {
        return accu;
    }

    public Register getRegister1() {
        return register1;
    }

    public Register getRegister2() {
        return register2;
    }

    public Register getRegister3() {
        return register3;
    }

    public CommandRegister getCommandRegister() {
        return commandRegister;
    }

    public int getCommandPointer() {
        return commandPointer;
    }

    public void setCommandPointer(int commandPointer) {
        this.commandPointer = commandPointer;
    }

    public int getCommandCounter() {
        return commandCounter;
    }

    public void setCommandCounter(int commandCounter) {
        this.commandCounter = commandCounter;
    }

    public boolean isCarryBit() {
        return carryBit;
    }

    public void setCarryBit(boolean carryBit) {
        this.carryBit = carryBit;
    }

    public boolean getCarryBit() {
        return carryBit;
    }
}
