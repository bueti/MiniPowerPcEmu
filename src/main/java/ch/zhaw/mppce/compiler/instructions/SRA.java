package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 20:06
 */
public class SRA extends Instruction {
    @Override
    public String convertToOpcode() {
        return "00000101--------";
    }

    @Override
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
        Tools tools = new Tools();

        String accuVal = accu.getRegister();

        int accuValDec = tools.convertToDec(accuVal);

        accu.setRegister(tools.convertToBin(accuValDec / 2));

        // TODO: MSB Handling
    }
}
