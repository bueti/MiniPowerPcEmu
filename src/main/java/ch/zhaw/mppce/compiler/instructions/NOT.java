package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
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
    public String convertToOpcode(Memory dataMemory) {
        return "000000001-------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        String accuVal = accu.getRegister();

        int accuValInt = Integer.parseInt(accuVal, 2);

        int shifted = ~accuValInt;

        accu.setRegister(tools.convertToBin(shifted, 16));

        // Increase command counter
        cpu.incCommandPointer();
    }
}
