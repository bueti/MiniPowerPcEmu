package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:48
 * <p/>
 * ADD Rnr
 * <p/>
 * Addition zweier 16-Bit-Zahlen (Zahl im Akku und Zahl im Register «Rxx »;
 * 00 bis 11 für Akku, R-1, R-2 bzw. R-3) im 2er -Komplement; bei Überlauf
 * wird das Carry-Flag gesetzt (= 1), sonst auf den Wert 0.
 */
public class ADD extends Instruction {
    // Instance Variables

    /**
     * Constructor
     *
     * @param parameters the number of the register
     */
    public ADD(String parameters) {
        super(parameters);
    }


    // Methods

    @Override
    public void doIt(Memory programMemory, Memory dataMemory,
                     Register accu, Register register1, Register register2, Register register3) {
        Register registerData = null;
        Tools tools = new Tools();

        // Get Register from Params
        registerData = tools.getRegisterFromParams(getParameters());

        // Calculate: accu = accu + registerData
        String accuVal = accu.getRegister();
        String regVal = registerData.getRegister();

        // String Values to int
        int accuVal2 = Integer.parseInt(accuVal);
        int regVal2 = Integer.parseInt(regVal);

        // Do the math
        int finalValue = accuVal2 + regVal2;

        // Convert to two's complement
        if (finalValue == 0) {
            accu.setRegister("0000000000000000");
        } else {
            String converted = tools.convertToBin(finalValue);
            // Save it to the accu
            accu.setRegister(converted);
        }

    }

    @Override
    public String convertToOpcode() {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0000" + register + "1010000000";
    }

}
