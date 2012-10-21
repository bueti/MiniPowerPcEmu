package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
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
    public String convertToOpcode(Memory dataMemory) {
        return "00001001--------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        String accuVal = accu.getRegister();

        // Get last bit and set it as carry bit
        String carryBit = accuVal.substring(15);
        if (carryBit.equals("0")) {
            cpu.setCarryBit(false);
        } else {
            cpu.setCarryBit(true);
        }

        int accuValInt = Integer.parseInt(accuVal, 2);

        // unsigned right shift (accuValInt / 2)
        int accuShifted = accuValInt >>> 1;

        accu.setRegister(tools.convertToBin(accuShifted, 16));

        // Increase command counter
        cpu.incCommandPointer();

    }
}
