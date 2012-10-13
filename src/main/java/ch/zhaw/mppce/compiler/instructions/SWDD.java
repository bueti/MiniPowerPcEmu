package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:11
 */
public class SWDD extends Instruction {
    public SWDD(String parameters) {
        super(parameters);
    }

    @Override
    public String convertToBinary() {
        String params = getParameters();
        String register = params.split(",")[0].trim().replaceAll("[^\\d]","");
        if(register.equals("0"))
            register = "00";

        String address =  params.split(",")[1].trim().replaceAll("[^\\d]","");
        // TODO: get value from address
        String value = address;

        return "0111" + register + value;
    }
}
