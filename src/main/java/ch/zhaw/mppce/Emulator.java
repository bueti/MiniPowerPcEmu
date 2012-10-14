package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.Register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 14.10.12
 * Time: 21:58
 */
public class Emulator {
    // Startwerte des Memories
    private static final int PROGRAM_START = 100;
    private static final int DATA_START = 200;

    // Instance Variables
    private final HashMap<String, Instruction> programMemory;
    private final HashMap<String, String> dataMemory;
    private final ArrayList<String> commandRegister;
    private final Register accu;
    private final Register register1;
    private final Register register2;
    private final Register register3;
    private int commandCounter;

    // Constructor
    public Emulator(HashMap<String, Instruction> programMemory, HashMap<String, String> dataMemory,
                    ArrayList<String> commandRegister, Register accu, Register register1,
                    Register register2, Register register3) {

        this.programMemory = programMemory;
        this.dataMemory = dataMemory;
        this.commandRegister = commandRegister;
        this.accu = accu;
        this.register1 = register1;
        this.register2 = register2;
        this.register3 = register3;

        setCommandCounter(PROGRAM_START);

    }

    // Run the program stored in programMemory
    public void run() {
        while(commandCounter < DATA_START ) {
            Instruction instr = programMemory.get(Integer.toString(commandCounter));
            if(instr != null) {
                instr.doIt(programMemory, dataMemory, accu, register1, register2, register3);
            }
            incCommandCounter();

        }
        System.out.println(getCommandCounter());

    }


    // Getter - Setter
    public int getCommandCounter() {
        return commandCounter;
    }

    public void setCommandCounter(int commandCounter) {
        this.commandCounter = commandCounter;
    }

    public void incCommandCounter() {
        commandCounter = commandCounter + 2;
    }
}
