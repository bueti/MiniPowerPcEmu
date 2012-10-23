package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.gui.Gui;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 14.10.12
 * Time: 21:58
 */
public class Emulator {
    // Instance Variables
    private CPU cpu;
    private Gui gui;
    private Memory programMemory;
    private Memory dataMemory;

    // Constructor
    public Emulator(CPU cpu, Gui gui) {
        this.cpu = cpu;
        this.gui = gui;
        this.programMemory = cpu.getProgramMemory();
        this.dataMemory = cpu.getDataMemory();

    }

    // Run the program stored in programMemory
    public void run(String mode) {
        String end = "";
        while (!end.equals("END")) {

            Instruction instr = programMemory.getCommand(Integer.toString(cpu.getCommandPointer()));
            if (instr != null) {
                instr.doIt(cpu);
                end = instr.getClass().getSimpleName();
                cpu.storeToCommandRegister(instr.convertToOpcode(dataMemory));
                //gui.setCommandArea(instr.convertToOpcode(dataMemory));
            }
            cpu.incCommandCounter();

        }
        // Update GUI TODO: Make it really update
        gui.setpMemoryArea(cpu.getCommandRegisterAsString());
        gui.setdMemoryArea(dataMemory.getDataMemoryAsString());
        gui.setCommandArea(programMemory.getProgramMemoryAsString());
        gui.setRegister1Field(cpu.printRegister1());
        gui.setRegister2Field(cpu.printRegister2());
        gui.setRegister3Field(cpu.printRegister3());
        gui.setAccuField(cpu.printAccumulator());
        gui.setCounterField(cpu.getCommandCounter());
        gui.displayCarryBit(cpu.getCarryBit());
    }

}
