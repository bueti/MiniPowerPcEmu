package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 20.10.12
 * Time: 15:22
 */
public class BZ extends Instruction {
    @Override
    public String convertToOpcode(Memory dataMemory) {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0001" + register + "10-------";
    }

    @Override
    public void doIt(CPU cpu) {
        Register accu = cpu.getAccu();

        if (accu.getRegister().equals("0000000000000000")) {
            // branch to address
            String address = getParameters();
            cpu.setCommandPointer(Integer.getInteger(address));
        } else {
            cpu.incCommandPointer();
        }
    }
}
