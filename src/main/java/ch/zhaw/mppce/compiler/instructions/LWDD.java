package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:04
 */
public class LWDD extends Instruction {
    // Instance Vars

    // Constructor
    public LWDD(String parameters) {
        super(parameters);
    }

    // Methods

    @Override
    public String doIt() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String convertToBinary() {
        String[] params = getParameters().split(" ");
        String register = convertRegister(Integer.parseInt(params[1].replace("R", "").replace(",", "")));
        String address = params[2].replace("#", "");

        // Get Value from Address
        HashMap<String, String> data = CPU.getDataMemory();
        String value = data.get(address);

        return "0100--" + register + value;
    }
}
