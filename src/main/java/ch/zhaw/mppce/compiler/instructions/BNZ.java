package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;

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
        Register accu = cpu.getAccu();

        if (!accu.getRegister().equals("0000000000000000")) {
            // branch to address
            String address = getParameters();
            cpu.setCommandPointer(Integer.getInteger(address));
        }
    }
}
