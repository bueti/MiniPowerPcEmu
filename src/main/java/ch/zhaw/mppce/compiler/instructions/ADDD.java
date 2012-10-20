package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.cpu.Register;
import ch.zhaw.mppce.tools.Tools;

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
    public void doIt(CPU cpu) {
        Tools tools = new Tools();
        Register accu = cpu.getAccu();

        // Get value from accu
        String accuVal = accu.getRegister();

        // Get value from parameter
        String value = tools.getValueFromParams(1, getParameters());

        // Convert both to dec
        int accuValDec = tools.convertToDec(accuVal);
        int valueDec = Integer.valueOf(value);

        // Calculate
        int result = accuValDec + valueDec;

        // TODO: Check for overflow   -- really necessary??

        // Convert to twos complement
        String convertedResult = tools.convertToBin(result);

        // save it
        accu.setRegister(convertedResult);
    }

    // TODO: Test
    @Override
    public String convertToOpcode(Memory dataMemory) {
        String address = getParameters();
        String value = dataMemory.getValue(address);

        return "1" + value;
    }
}
