package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 20:52
 */
public class END extends Instruction {

    @Override
    public String convertToOpcode() {
        return "0000000000000000";
    }

    @Override
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
        System.out.println("Ende erreicht.");
    }
}
