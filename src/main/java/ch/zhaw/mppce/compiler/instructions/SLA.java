package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 20:11
 */
public class SLA extends Instruction {

    @Override
    public String convertToOpcode(Memory dataMemory) {
        return "00001000--------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        String accuVal = accu.getRegister();

        // Get second bit and set it as carry bit
        String carryBit = accuVal.substring(1, 2);
        if (carryBit.equals("0")) {
            cpu.setCarryBit(false);
        } else {
            cpu.setCarryBit(true);
        }

        int accuValDec = tools.convertToDec(accuVal);

        accu.setRegister(tools.convertToBin(accuValDec * 2, 16));


        // Increase command counter
        cpu.incCommandPointer();
    }
}
