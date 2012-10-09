package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:48
 */
public class ADD extends Instruction {

    /**
     * ADD Rnr
     *
     * Addition zweier 16-Bit-Zahlen (Zahl im Akku und Zahl im Register «Rxx »;
     * 00 bis 11 für Akku, R-1, R-2 bzw. R-3) im 2er -Komplement; bei Überlauf
     * wird das Carry-Flag gesetzt (= 1), sonst auf den Wert 0.
     *
     * @param  registerNr  the number of the register
     *
     */
    public ADD(int registerNr) {
        add(registerNr);
    }

    // Methods
    public void add(int registerNr) {
        // get data

        // addition

        // store data
    }
}
