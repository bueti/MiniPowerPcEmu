package ch.zhaw.mppce.compiler.instructions;

/**
 * CLR Rnr
 *
 * Lösche das Register «Rxx » (alle Bit auf 0 setzten) und das
 * Carry-Flag (00 bis 11 für: Akku, R-1, R-2 bzw. R-3).
 *
 */
public class CLR extends Instruction {
    // Instance Variables

    /**
    * @param  parameters  the number of the register
    *
    */
    public CLR(String parameters) {
        super(parameters);
    }

    // Methods

    @Override
    public String doIt() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String convertToBinary() {
        String register = getParameters().trim().replaceAll("[^\\d]","");
        return "0000" + register + "1010000000";
    }

}
