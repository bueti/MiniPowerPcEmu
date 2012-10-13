package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:38
 */
public abstract class Instruction {
    private String parameters;

    public Instruction() {};

    public Instruction(String parameters) {
        this.parameters = parameters;
    }

    public abstract String convertToBinary();

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
