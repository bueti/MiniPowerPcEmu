package ch.zhaw.mppce.cpu;

import ch.zhaw.mppce.compiler.instructions.Instruction;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:47
 */
public abstract class Memory {

    public abstract void storeCommand(int address, Instruction command);
    public abstract Instruction getCommand(int address);
    public abstract HashMap<Integer, Instruction> getMemory();

}
