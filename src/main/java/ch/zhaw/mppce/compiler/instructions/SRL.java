package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 20:46
 */
public class SRL extends Instruction {

    @Override
    public String convertToOpcode() {
        return "00001001--------";
    }

    @Override
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
        Tools tools = new Tools();

        String accuVal = accu.getRegister();

        int accuValInt = Integer.getInteger(accuVal, 2);

        int accuShifted = accuValInt << 1;

        accu.setRegister(tools.convertToBin(accuShifted));

    }
}
