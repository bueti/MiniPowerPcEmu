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

}
