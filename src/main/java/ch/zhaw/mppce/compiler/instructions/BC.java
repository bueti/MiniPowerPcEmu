package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 20.10.12
 * Time: 15:41
 */
public class BC extends Instruction {
    @Override
    public String convertToOpcode(Memory dataMemory) {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0001" + register + "11-------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        String address = getParameters();
        Register register = tools.getRegisterFromParams(cpu, address);

        if (register.hasCarryBit()) {
            // convert register value to decimal
            int newAddr = tools.convertToDec(register.getRegister());

            // branch to address
            cpu.setCommandPointer(newAddr);
        } else {
            cpu.incCommandPointer();
        }
    }
}
