package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:02
 */
public class INC extends Instruction {

    @Override
    public String convertToBinary() {
        return "0000000100000000";
    }
}
