package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:02
 */
public class INC extends Instruction {

    @Override
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
        Tools tools = new Tools();

        // Get Value in Accumulator);
        String accuValue = accu.getRegister();

        // TODO: Check for overflow and set carry bit.
        // Convert to Dec
        int a = Integer.parseInt(accuValue);

        // +1
        a++;

        // Convert to Twos Complement
        accuValue = tools.twoComplement(a);

        // Save
        accu.setRegister(accuValue);
    }

    @Override
    public String convertToOpcode() {
        return "00000001--------";
    }
}
