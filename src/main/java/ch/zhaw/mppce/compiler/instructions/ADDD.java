package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:48
 * <p/>
 * ADDD #Address
 * <p/>
 * Addition der 16-Bit-Zahl im Akku mit der 15-Bit-Zahl als direkten Operanden
 * im 2er -Komplement; bei Überlauf wird das Carry-Flag gesetzt (=1),
 * sonst auf den Wert 0 . Vor der Addition wird die 15-Bit-Zahl des Operanden
 * auf 16 Bit erweitert (mit MSb des MSB auf 1 wenn negativ, sonst auf 0 ).
 */
public class ADDD extends Instruction {
    // Instance Variable

    /**
     * Constructor
     *
     * @param parameters
     */
    public ADDD(String parameters) {
        super(parameters);
    }

    // Methods

    @Override
    public void doIt(Memory programMemory, Memory dataMemory, Register accu, Register register1, Register register2, Register register3) {
    }

    @Override
    public String convertToBinary() {
        String address = getParameters();
        // TODO: Get Value from Address
        String value = " v: ";

        return "1" + value;
    }
}
