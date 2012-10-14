package ch.zhaw.mppce.compiler.instructions;

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
    public String convertToBinary() {
        //String register = getParameters().trim().replaceAll("[^\\d]","");
        String register = convertRegister(Integer.parseInt(getParameters().trim().replaceAll("[^\\d]", "")));

        return "0000" + register + "1010000000";
    }

}
