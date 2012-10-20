package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:11
 */
public class SWDD extends Instruction {
    public SWDD(String parameters) {
        super(parameters);
    }

    @Override
    public void doIt(CPU cpu) {
        /**
         *  Parse Parameters, we need a:
         *  - Register R1, R2 or R3
         *  - Value of Address + Address+1
         *  Then we save the value of the register into the address
         */
        Tools tools = new Tools();
        String params = getParameters();
        Memory dataMemory = cpu.getDataMemory();

        // Get Register from Params
        Register registerData = tools.getRegisterFromParams(cpu, params);

        // Get address from Params
        int address = tools.getAddressFromParams(params);

        // Get value from register
        String regVal = registerData.getRegister();

        // Split into two 8 bit strings
        String val1 = regVal.substring(0, 8);
        String val2 = regVal.substring(8);

        // Save them to the memory
        dataMemory.setValue(address, val2);
        dataMemory.setValue(address + 1, val1);

        // Increase command counter
        cpu.incCommandPointer();
    }

    @Override
    public String convertToOpcode(Memory dataMemory) {
        String value;
        Tools tools = new Tools();

        Memory data = dataMemory;
        String[] params = getParameters().split(" ");
        String register = convertRegister(Integer.parseInt(params[1].replace("R", "").replace(",", "")));

        if (params[2].contains("#")) {
            // Get Value from Address
            value = data.getValue(params[2].replace("#", ""));
        } else {
            value = tools.convertToBin(Integer.valueOf(params[2]));
        }

        return "011---" + register + value;
    }
}
