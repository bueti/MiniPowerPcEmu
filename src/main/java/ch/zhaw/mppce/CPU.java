package ch.zhaw.mppce;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:50
 */
public class CPU {

    // Instance Variables
    private Register register1;
    private Register register2;
    private Register register3;
    private Register accu;
    private Register commandRegister;

    private Memory programMemory;
    private Memory dataMemory;

    private int commandCounter;
    private Mnemonic2BinaryConverter m2b;

    /**
     * Constructor
     */
    public CPU() {
        // Initialize Registers
        register1 = new Register();
        register2 = new Register();
        register3 = new Register();

        accu = new Accumulator();
        commandRegister = new CommandRegister();

        // Initialize Memory
        programMemory = new ProgramMemory();
        dataMemory = new DataMemory();

        // Misc
        commandCounter = 0;
        m2b = new Mnemonic2BinaryConverter();

    }
}
