package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Accumulator;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Register;

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
    public void doIt(HashMap<String, Instruction> programMemory, HashMap<String, String> dataMemory, Accumulator accu, Register register1, Register register2, Register register3) {
    }

    @Override
    public String convertToBinary() {
        String address;
        String value;

        HashMap<String, String> data = CPU.getDataMemory();
        String[] params = getParameters().split(" ");
        String register = convertRegister(Integer.parseInt(params[1].replace("R", "").replace(",", "")));

        if(params[2].contains("#")) {
            // Get Value from Address
            address = params[2].replace("#", "");
            value = data.get(address);
        } else {
            // TODO: Konstante in Binary konvertieren
            value = "";
        }

        return "0100--" + register + value;
    }
}
