package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 20:52
 */
public class END extends Instruction {

    @Override
    public String convertToOpcode(Memory dataMemory) {
        return "0000000000000000";
    }

    @Override
    public void doIt(CPU cpu) {
        System.out.println("Ende erreicht.");
    }
}
