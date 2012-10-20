package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:47
 */
public class Memory {
    // Instance Variables
    private HashMap<String, Instruction> programMemory;
    private HashMap<String, String> dataMemory;

    public Memory() {
        programMemory = new HashMap<String, Instruction>();
        dataMemory = new HashMap<String, String>();
    }

//    public abstract HashMap<String, Instruction> getMemory();

    /**
     * Store a given command
     *
     * @param instructionNr Address of command
     * @param command       commando
     */
    public void storeCommand(String instructionNr, Instruction command) {
        programMemory.put(instructionNr, command);
    }

    public void storeCommand(String dataNr, String data) {
        dataMemory.put(dataNr, data);
    }


    public Instruction getCommand(String instructionNr) {
        return programMemory.get(instructionNr);
    }

    public HashMap<String, Instruction> getProgramMemory() {
        return programMemory;
    }

    public HashMap<String, String> getDataMemory() {
        return dataMemory;
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

    public void printProgramMemory() {
        for (Map.Entry<String, Instruction> entry : programMemory.entrySet()) {
            String key = entry.getKey();
            Instruction instr = entry.getValue();
            System.out.println(key + " + " + instr);
        }
    }
}
