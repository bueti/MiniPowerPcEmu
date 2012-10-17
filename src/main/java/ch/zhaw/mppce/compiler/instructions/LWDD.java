package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:04
 * <p/>
 * LWDD
 * <p/>
 * In das Register mit der Nummer xx (00 bis 11 für Akku, R-1, R-2 bzw. R-3) wird
 * der Inhalt der Speicherzellen Adr und Adr + 1 (1 Wort = 2 Byte) geladen.
 * Mit 10 Bit können 1KiB Speicher adressiert werden.
 */
public class LWDD extends Instruction {
    // Instance Vars

    // Constructor
    public LWDD(String parameters) {
        super(parameters);
    }

    // Methods
    @Override
    public void doIt(Memory programMemory, Memory dataMemory,
                     Register accu, Register register1, Register register2, Register register3) {
        /**
         *  Parse Parameters, we need a:
         *  - Register R1, R2 or R3
         *  - Value of Address + Address+1
         */
        Tools tools = new Tools();
        String params = getParameters();

        // Get Register from Params
        Register registerData = tools.getRegisterFromParams(params);

        // Get address from Params
        int address = tools.getAddressFromParams(params);

        // Get values from address and address + 1
        String value1 = dataMemory.getValue(Integer.toString(address));
        String value2 = dataMemory.getValue(Integer.toString(address) + 1);
        if (value2 == null)
            value2 = "0000000000000000";

        // Add value1 + value2
        int i = Integer.parseInt(value1, 2);
        int j = Integer.parseInt(value2, 2);
        int result = i + j;

        // Convert result to two's complement,
        String converted = tools.twoComplement(result);

        // Write it into the Register
        registerData.setRegister(converted);

    }

    @Override
    public String convertToOpcode() {
        String address;
        String value;

        Memory data = CPU.getDataMemory();
        String[] params = getParameters().split(" ");
        String register = convertRegister(Integer.parseInt(params[1].replace("R", "").replace(",", "")));

        if (params[2].contains("#")) {
            // Get Value from Address
            address = params[2].replace("#", "");
            value = data.getValue(address);
        } else {
            // TODO: Konstante in Binary konvertieren
            value = "";
        }

        return "0100--" + register + value;
    }
}
