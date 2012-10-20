package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

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

    private int commandCounter;


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
        commandCounter = 0;

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

    // Methods
    public void addCommandToMemory(String instructionNr, Instruction command) {
        programMemory.storeCommand(instructionNr, command);
    }

    public void addCommandToMemory(String dataNr, String data) {
        dataMemory.storeCommand(dataNr, data);
    }

    public void printAccumulator() {
        System.out.println("Accu: " + accu.getRegister());
    }

//    public void printProgramMemory() {
//        for (Map.Entry<String, Instruction> entry : getProgramMemory().entrySet()) {
//            String address = entry.getKey();
//            Instruction instr = entry.getValue();
//            // ..
//            System.out.println(address + " -> " + instr.getClass());
//        }
//    }
//
//    public void printDataMemory() {
//        for (Map.Entry<String, String> entry : getDataMemory().entrySet()) {
//            String address = entry.getKey();
//            String value = entry.getValue();
//            // ..
//            System.out.println(address + " -> " + value);
//        }
//    }

    public void storeToCommandRegister(String command) {
        commandRegister.addCommand(command);
    }

    // Display the whole command register
//    public void printCommandRegister() {
//        for (String command : getCommandRegister()) {
//            System.out.println("CR: " + command);
//        }
//    }
}
