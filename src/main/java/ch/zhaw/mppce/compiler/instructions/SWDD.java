package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
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
        // TODO: Implement
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
