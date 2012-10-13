package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:04
 */
public class DEC extends Instruction {

    @Override
    public String convertToBinary() {
        return "0000010000000000";
    }
}
