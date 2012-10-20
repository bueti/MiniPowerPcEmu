package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
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
    public void doIt(CPU cpu) {
        Register registerData = null;
        Register accu = cpu.getAccu();
        Tools tools = new Tools();
        boolean overflow = false;

        // Get Register from Params
        registerData = tools.getRegisterFromParams(cpu, getParameters());

        // Calculate: accu = accu + registerData
        String accuVal = accu.getRegister();
        String regVal = registerData.getRegister();

        // String Values to int
        int accuValDec = tools.convertToDec(accuVal);
        int regValDec = tools.convertToDec(regVal);

        // Do the math
        int finalValue = accuValDec + regValDec;

        // Check if Carry Bit is necessary:
        if (finalValue >= 16384)
            overflow = true;

        // Convert to two's complement
        if (finalValue == 0) {
            accu.setRegister("0000000000000000");
        } else {
            String converted = tools.convertToBin(finalValue);
            // Save it to the accu
            accu.setRegister(converted);
            if (overflow)
                accu.setCarryBit();
        }

        // Increase command counter
        cpu.incCommandPointer();

    }

    @Override
    public String convertToOpcode(Memory dataMemory) {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0000" + register + "1010000000";
    }

}
