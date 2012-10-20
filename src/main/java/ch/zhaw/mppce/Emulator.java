package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.CommandRegister;
import ch.zhaw.mppce.cpu.Memory;

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
    private CommandRegister commandRegister;   // TODO: Fill Command Register
    private int commandCounter;

    // Constructor
    public Emulator(CPU cpu) {
        this.cpu = cpu;
        this.programMemory = cpu.getProgramMemory();
        this.commandRegister = cpu.getCommandRegister();

        setCommandCounter(PROGRAM_START);

    }

    // Run the program stored in programMemory
    public void run() {
        Instruction instr;
        while (cpu.getCommandCounter() < DATA_START) {
            instr = programMemory.getCommand(Integer.toString(cpu.getCommandPointer()));
            if (instr != null) {
                instr.doIt(cpu);
            }
            cpu.incCommandCounter();

            // Print Accumulator & Registers
            cpu.printAccumulator();
            cpu.printRegisters();

            // Print Memory
            cpu.printProgramMemory();
            cpu.printDataMemory();

        }
        System.out.println(getCommandCounter());

    }


    // Getter - Setter
    public int getCommandCounter() {
        return commandCounter;
    }

    public void setCommandCounter(int commandCounter) {
        this.commandCounter = commandCounter;
    }

}
