package ch.zhaw.mppce.compiler.instructions;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 20:38
 */
public abstract class Instruction {
    // Instance Vars
    private String parameters;

    // Constructors
    public Instruction() {};

    public Instruction(String parameters) {
        this.parameters = parameters;
    }

    // Abstract Methods
    public abstract String convertToBinary();
    public abstract String doIt();

    // Methods
    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String convertRegister(int i) {
        String register = null;
        register = register.format("%2s", Integer.toBinaryString(i)).replace(' ', '0');
        return register;
    }

}
