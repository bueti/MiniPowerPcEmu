package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:47
 */
public class ProgramMemory extends Memory {

    private HashMap<Integer, Instruction> programMemory;


    public ProgramMemory() {
        super();
        programMemory = new HashMap<Integer, Instruction>();
    }

    /**
     * Store a given command
     *
     * @param address   Address of command
     * @param command   commando
     *
     */
    public void storeCommand(int address, Instruction command) {
        programMemory.put(address, command);

    }

    /**
     * Get given command by address
     *
     *
     * @param address
     * @return command
     *
     */
    public Instruction getCommand(int address) {
        return programMemory.get(address);

    }

    public HashMap<Integer, Instruction> getMemory() {
        return programMemory;
    }
}
