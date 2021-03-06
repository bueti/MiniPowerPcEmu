package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:47
 */
public class Memory {
    // Instance Variables
    private TreeMap<String, Instruction> programMemory;
    private TreeMap<String, String> dataMemory;

    public Memory() {
        programMemory = new TreeMap<String, Instruction>();
        dataMemory = new TreeMap<String, String>();
    }

    /**
     * Store a given command
     *
     * @param instructionNr Address of command
     * @param command       commando
     */
    public void storeCommand(String instructionNr, Instruction command) {
        programMemory.put(instructionNr, command);
    }


    public Instruction getCommand(String instructionNr) {
        return programMemory.get(instructionNr);
    }

    public String getValue(String address) {
        return dataMemory.get(address);
    }

    public void setValue(int address, String value) {
        // Remove old entry if existing
        dataMemory.remove(Integer.toString(address));
        // Store new
        dataMemory.put(Integer.toString(address), value);

    }

    public TreeMap<String, String> getDataMemoryAsTree() {
        return dataMemory;
    }

    public TreeMap<String, Instruction> getProgramMemoryAsTree() {
        return programMemory;
    }
}
