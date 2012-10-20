package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 19.10.12
 * Time: 22:31
 */
public class OR extends Instruction {

    @Override
    public String convertToOpcode(Memory dataMemory) {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0000" + register + "110-------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        // Get Register from Params
        Register registerData = tools.getRegisterFromParams(cpu, getParameters());

        String accuVal = accu.getRegister();
        String regVal = registerData.getRegister();

        int accuValInt = Integer.getInteger(accuVal, 2);
        int regValInt = Integer.getInteger(regVal, 2);

        int shifted = accuValInt ^ regValInt;

        accu.setRegister(tools.convertToBin(shifted));

        // Increase command counter
        cpu.incCommandPointer();
    }
}
