package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.CommandRegister;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 14.10.12
 * Time: 21:58
 */
public class Emulator {
    // Startwerte des Memories
    private static final int PROGRAM_START = 100;
    private static final int DATA_START = 500;

    // Instance Variables
    private CPU cpu;
    private Memory programMemory;
    private Memory dataMemory;
    private CommandRegister sdfscommandRegister;   // TODO: Fill Command Register
    private Register accu;
    private Register register1;
    private Register register2;
    private Register register3;
    private int commandCounter;

    // Constructor
//    public Emulator(Memory programMemory, Memory dataMemory, CommandRegister commandRegister,
//                    Register accu, Register register1, Register register2, Register register3) {
    public Emulator(CPU cpu) {
        this.cpu = cpu;
        this.programMemory = cpu.getProgramMemory();
        this.dataMemory = cpu.getDataMemory();
        this.commandRegister = cpu.getCommandRegister();
        this.accu = cpu.getAccu();
        this.register1 = cpu.getRegister1();
        this.register2 = cpu.getRegister2();
        this.register3 = cpu.getRegister3();

        setCommandCounter(PROGRAM_START);

    }

    // Run the program stored in programMemory
    public void run() {
        Instruction instr;
        while (commandCounter < DATA_START) {
            instr = programMemory.getCommand(Integer.toString(commandCounter));
            if (instr != null) {
                instr.doIt(cpu);
            }
            incCommandCounter();

        }
        System.out.println(getCommandCounter());
        // Print Accumulator
        cpu.printAccumulator();

        // Print ProgramMemory
//        cpu.printProgramMemory();

        // Print DataMemory
//        cpu.printDataMemory();

    }


    // Getter - Setter
    public int getCommandCounter() {
        return commandCounter;
    }

    public void setCommandCounter(int commandCounter) {
        this.commandCounter = commandCounter;
    }

    public void incCommandCounter() {
        commandCounter = commandCounter + 2;
    }
}
