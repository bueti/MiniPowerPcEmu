package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:49
 */
public class DataMemory extends Memory {
    @Override
    public void storeCommand(String instruction, Instruction command) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Instruction getCommand(String instruction) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public HashMap<String, Instruction> getMemory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void storeData(String dataNr, String data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
