package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:04
 */
public class LWDD extends Instruction {

    public LWDD(String parameters) {
        super(parameters);
    }

    @Override
    public String convertToBinary() {
        String params = getParameters().trim();
        String register = params.substring(0).trim().replaceAll("[^\\d]","");
        String address = params.substring(1);
        // TODO: Get Value from Address
        String value = "WERT";

        return "0100" + register + value;
    }
}
