package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 20:47
 */
public class SLL extends Instruction {

    @Override
    public String convertToOpcode(Memory dataMemory) {
        return "00001100--------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        String accuVal = accu.getRegister();
        int accuValDec = tools.convertToDec(accuVal);

        // Get first bit and set it as carry bit
        String carryBit = accuVal.substring(0, 0);
        if (carryBit.equals(0)) {
            cpu.setCarryBit(false);
        } else {
            cpu.setCarryBit(true);
        }

        int accuValInt = Integer.parseInt(accuVal, 2);
        // left shift
        int accuShifted = accuValInt << 1;

        // Save new value
        accu.setRegister(tools.convertToBin(accuValDec * 2, 16));

        // Increase command counter
        cpu.incCommandPointer();
    }
}
