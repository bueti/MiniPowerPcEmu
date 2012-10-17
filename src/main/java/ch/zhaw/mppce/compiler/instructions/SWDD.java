package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;

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
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
    }

    @Override
    public String convertToOpcode() {
        String params = getParameters();
        String register = convertRegister(Integer.parseInt(params.split(",")[0].trim().replaceAll("[^\\d]", "").replace(",", "")));

        String address = params.split(",")[1].trim().replaceAll("[^\\d]", "");

        // Get Value from Address
        //HashMap<String, String> data = CPU.getDataMemory();
        //String value = data.get(address);
        String value = "n/a";

        return "011---" + register + value;
    }
}
