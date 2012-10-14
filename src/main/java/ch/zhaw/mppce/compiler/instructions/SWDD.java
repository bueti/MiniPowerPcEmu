package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;

import java.util.HashMap;

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
    public String doIt() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String convertToBinary() {
        String params = getParameters();
        String register = convertRegister(Integer.parseInt(params.split(",")[0].trim().replaceAll("[^\\d]", "").replace(",", "")));

        String address =  params.split(",")[1].trim().replaceAll("[^\\d]","");

        // Get Value from Address
        HashMap<String, String> data = CPU.getDataMemory();
        String value = data.get(address);

        return "011---" + register + value;
    }
}
