package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:48
 */
public class ADDD extends Instruction {
    public ADDD() {
    }

    /**
     * ADDD #Address
     *
     * Addition der 16-Bit-Zahl im Akku mit der 15-Bit-Zahl als direkten Operanden
     * im 2er -Komplement; bei Überlauf wird das Carry-Flag gesetzt (=1),
     * sonst auf den Wert 0 . Vor der Addition wird die 15-Bit-Zahl des Operanden
     * auf 16 Bit erweitert (mit MSb des MSB auf 1 wenn negativ, sonst auf 0 ).
     *
     * @param  address  the number of the register
     *
     */

    public ADDD(int address) {
        addd(address);
    }

    // Methods
    public void addd(int address) {
        // get data

        // addition

        // store data
    }
}
