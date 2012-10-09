package ch.zhaw.mppce.compiler.instructions;


public class CLR extends Instruction {
    // Instance Variables

    /**
     * CLR Rnr
     *
     * Lösche das Register «Rxx » (alle Bit auf 0 setzten) und das
     * Carry-Flag (00 bis 11 für: Akku, R-1, R-2 bzw. R-3).
     *
     * @param  registerNr  the number of the register
     *
     */
    public CLR(int registerNr) {
        clr(registerNr);
    }

    // Methods
    public void clr(int registerNr) {
        // get data

        // switch 1 to 0

        // store data
    }
}
