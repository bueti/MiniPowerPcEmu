package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 20.10.12
 * Time: 16:02
 */
public class BNZD extends Instruction {

    /**
     * Constructor
     *
     * @param parameters the number of the register
     */
    public BNZD(String parameters) {
        super(parameters);
    }

    @Override
    public String convertToOpcode(Memory dataMemory) {
        Tools tools = new Tools();
        String address = tools.convertToBin(tools.getAddressFromParams(getParameters()), 11);

        return "00101" + address;
    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        if (!accu.getRegister().equals("0000000000000000")) {
            // convert register value to decimal
            int address = tools.getAddressFromParams(getParameters());

            // branch to address
            cpu.setCommandPointer(address);
        } else {
            cpu.incCommandPointer();
        }
    }
}
