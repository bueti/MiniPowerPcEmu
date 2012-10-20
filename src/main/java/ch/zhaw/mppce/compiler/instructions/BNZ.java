package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 20.10.12
 * Time: 15:39
 */
public class BNZ extends Instruction {
    @Override
    public String convertToOpcode(Memory dataMemory) {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0001" + register + "01-------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();
        Register register = tools.getRegisterFromParams(cpu, getParameters());

        if (!accu.getRegister().equals("0000000000000000")) {
            // convert register value to decimal
            int newAddr = tools.convertToDec(register.getRegister());

            // branch to address
            cpu.setCommandPointer(newAddr);
        } else {
            cpu.incCommandPointer();
        }
    }
}
