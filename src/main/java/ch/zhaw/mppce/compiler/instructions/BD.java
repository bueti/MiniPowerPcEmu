package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 20.10.12
 * Time: 16:10
 */
public class BD extends Instruction {

    /**
     * Constructor
     *
     * @param parameters the number of the register
     */
    public BD(String parameters) {
        super(parameters);
    }


    @Override
    public String convertToOpcode(Memory dataMemory) {
        Tools tools = new Tools();
        String address = tools.convertToBin(tools.getAddressFromParams(getParameters()), 11);

        return "00100" + address;

    }

    @Override
    public void doIt(CPU cpu) {
        Tools tools = new Tools();

        // branch to address
        cpu.setCommandPointer(tools.getAddressFromParams(getParameters()));
    }
}
