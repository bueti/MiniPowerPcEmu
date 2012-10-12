package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:38
 */
public abstract class Instruction {
    private String command;
    private String params;

    public Instruction() {};

    public Instruction(String command, String params) {
        this.command = command;
        this.params = params;
    }

    public Instruction convertToBinary(Instruction instr) { return instr; }

}
