package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Register;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:48
 *
 * ADD Rnr
 *
 * Addition zweier 16-Bit-Zahlen (Zahl im Akku und Zahl im Register «Rxx »;
 * 00 bis 11 für Akku, R-1, R-2 bzw. R-3) im 2er -Komplement; bei Überlauf
 * wird das Carry-Flag gesetzt (= 1), sonst auf den Wert 0.
 *
 */
public class ADD extends Instruction {
     // Instance Variables

    /**
     * Constructor
     *
     * @param  parameters  the number of the register
     */
    public ADD(String parameters) {
        super(parameters);
    }


    // Methods

    @Override
    public String doIt() {
        String result = null;
        Register accu = CPU.getAccu();
        Register registerData = null;

        // Get Register
        String register = getParameters().trim().replaceAll("[^\\d]","");
        if(register.equals("1")) {
            registerData = CPU.getRegister1();
        } else if (register.equals("10")) {
            registerData = CPU.getRegister2();
        } else {
            registerData = CPU.getRegister3();
        }

        // Calculate: accu = accu + registerData
        result = accu.getValue() + "-" + registerData.getValue();

        return result;
    }

    @Override
    public String convertToBinary() {
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0000" + register + "1010000000";
    }

}
