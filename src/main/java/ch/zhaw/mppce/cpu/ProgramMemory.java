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
    private HashMap<String, Instruction> programMemory;

    public ProgramMemory() {
        super();
    }


    /**
     * Get given command by address
     *
     *
     * @param instructionNr
     * @return command
     *
     */
//    @Override
//    public Instruction getCommand(String instructionNr) {
//        return programMemory.get(instructionNr);
//    }
//
//    @Override
//    public HashMap<String, Instruction> getMemory() {
//        return programMemory;
//    }
//
//    @Override
//    public void storeData(String dataNr, String data) {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
}
