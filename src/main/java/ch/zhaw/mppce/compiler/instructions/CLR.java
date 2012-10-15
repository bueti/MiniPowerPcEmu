package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Accumulator;
import ch.zhaw.mppce.cpu.Register;

import java.util.HashMap;

/**
 * CLR Rnr
 * <p/>
 * Lösche das Register «Rxx » (alle Bit auf 0 setzten) und das
 * Carry-Flag (00 bis 11 für: Akku, R-1, R-2 bzw. R-3).
 */
public class CLR extends Instruction {
    // Instance Variables

    /**
     * @param parameters the number of the register
     */
    public CLR(String parameters) {
        super(parameters);
    }

    // Methods

    @Override
    public void doIt(HashMap<String, Instruction> programMemory, HashMap<String, String> dataMemory, Accumulator accu, Register register1, Register register2, Register register3) {
        accu.setValue(0, "0000000000000000");
    }

    @Override
    public String convertToBinary() {
        String register = getParameters().trim().replaceAll("[^\\d]", "");
        return "0000" + register + "1010000000";
    }

}
