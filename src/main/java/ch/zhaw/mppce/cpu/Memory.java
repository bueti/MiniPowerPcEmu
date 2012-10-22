package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.HashMap;
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

    public TreeMap<String, Instruction> getProgramMemory() {
        return programMemory;
    }

    public TreeMap<String, String> getDataMemory() {
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
            System.out.println(key + ": " + instr.getClass().getSimpleName() + ": " + instr.getParameters());
        }
    }

    public void printDataMemory() {
        for (Map.Entry<String, String> entry : dataMemory.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    // Convert Mnemonics to Binary and save it to the command register
    public void convertMnemonics2Binary(CPU cpu) {
        for (Map.Entry<String, Instruction> entry : programMemory.entrySet()) {
            String key = entry.getKey();
            Instruction instr = entry.getValue();
            cpu.storeToCommandRegister(instr.convertToOpcode(cpu.getDataMemory()));
        }
    }

    public String getDataMemoryAsString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : dataMemory.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + ": " + value);
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    public String getProgramMemoryAsString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Instruction> entry : programMemory.entrySet()) {
            String key = entry.getKey();
            Instruction instr = entry.getValue();
            String value = instr.getClass().getSimpleName() + ": " + instr.getParameters();
            sb.append(key + ": " + value);
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }
}
