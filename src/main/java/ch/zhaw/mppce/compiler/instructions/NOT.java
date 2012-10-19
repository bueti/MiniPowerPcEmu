package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 22:32
 */
public class NOT extends Instruction {

    @Override
    public String convertToOpcode() {
        return "000000001-------";
    }

    @Override
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
        Tools tools = new Tools();

        String accuVal = accu.getRegister();

        int accuValInt = Integer.getInteger(accuVal, 2);

        int shifted = ~accuValInt;

        accu.setRegister(tools.convertToBin(shifted));
    }
}
