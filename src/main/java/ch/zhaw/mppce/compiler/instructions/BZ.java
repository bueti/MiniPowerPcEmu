package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 20.10.12
 * Time: 15:22
 */
public class BZ extends Instruction {

    /**
     * Constructor
     *
     * @param parameters the number of the register
     */
    public BZ(String parameters) {
        super(parameters);
    }


    @Override
    public String convertToOpcode(Memory dataMemory) {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0001" + register + "10-------";
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();
        Register register = tools.getRegisterFromParams(cpu, getParameters());

        if (accu.getRegister().equals("0000000000000000")) {
            // convert register value to decimal
            int newAddr = tools.convertToDec(register.getRegister());

            // branch to address
            cpu.setCommandPointer(newAddr);
        } else {
            cpu.incCommandPointer();
        }
    }
}
