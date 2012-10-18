package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

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
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
        Tools tools = new Tools();

        // Get Register from Params
        Register registerData = tools.getRegisterFromParams(getParameters());

        registerData.setRegister("0000000000000000");

    }

    @Override
    public String convertToOpcode() {
        String register = getParameters().trim().replaceAll("[^\\d]", "");
        return "0000" + register + "101-------";
    }

}
