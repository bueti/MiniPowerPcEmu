package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:48
 *
 *  ADDD #Address
 *
 * Addition der 16-Bit-Zahl im Akku mit der 15-Bit-Zahl als direkten Operanden
 * im 2er -Komplement; bei Überlauf wird das Carry-Flag gesetzt (=1),
 * sonst auf den Wert 0 . Vor der Addition wird die 15-Bit-Zahl des Operanden
 * auf 16 Bit erweitert (mit MSb des MSB auf 1 wenn negativ, sonst auf 0 ).
 *
 *
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
    public String doIt() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String convertToBinary() {
        String address = getParameters();
        // TODO: Get Value from Address
        String value = " v: ";

        return "1" + value;
    }
}
