package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.gui.Gui;

import java.util.Observable;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 14.10.12
 * Time: 21:58
 */
public class Emulator extends Observable implements Runnable {
    // Instance Variables
    private CPU cpu;
    private Memory programMemory;
    private Memory dataMemory;
    private Gui gui;

    private String mode;

    // Constructor
    public Emulator(CPU cpu, Gui gui, String mode) {
        this.cpu = cpu;
        this.programMemory = cpu.getProgramMemory();
        this.dataMemory = cpu.getDataMemory();
        this.gui = gui;
        this.addObserver(gui);
        setMode(mode);

    }

    // TODO: Implement Step Mode
    @Override
    public void run() {
        while (!end.equals("END")) {

            Instruction instr = programMemory.getCommand(Integer.toString(cpu.getCommandPointer()));
            if (instr != null) {
                instr.doIt(cpu);
                end = instr.getClass().getSimpleName();
                cpu.storeToCommandRegister(Integer.toString(cpu.getCommandPointer()), instr.convertToOpcode(dataMemory));
            }
            cpu.incCommandCounter();

            if (getMode().equals("slow")) {
                this.setChanged();
                this.notifyObservers();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.setChanged();
        this.notifyObservers();
        gui.setResultField(cpu.getResult());
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
