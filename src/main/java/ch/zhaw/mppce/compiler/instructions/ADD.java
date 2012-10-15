package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Accumulator;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Register;

import java.util.HashMap;

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
    public void doIt(HashMap<String, Instruction> programMemory, HashMap<String, String> dataMemory,
                     Accumulator accu, Register register1, Register register2, Register register3) {
        String result = null;
        Register registerData = null;

        // Get Register
        String register = getParameters().replaceAll("[^\\d]", "");
        if (register.equals("0")) {
            registerData = CPU.getRegister1();
        } else if (register.equals("1")) {
            registerData = CPU.getRegister2();
        } else {
            registerData = CPU.getRegister3();
        }

        // Calculate: accu = accu + registerData
        String accuVal = accu.getAccu();
        String regVal = registerData.getValue(0);
        accu.setValue(0, accuVal + " + " + regVal);

        //return accu.getValue(0);
    }

    @Override
    public String convertToBinary() {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0000" + register + "1010000000";
    }

}
