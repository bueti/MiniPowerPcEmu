package ch.zhaw.mppce.compiler.instructions;

import ch.zhaw.mppce.cpu.Accumulator;
import ch.zhaw.mppce.cpu.Register;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 13.10.12
 * Time: 16:04
 */
public class DEC extends Instruction {

    @Override
    public void doIt(HashMap<String, Instruction> programMemory, HashMap<String, String> dataMemory, Accumulator accu, Register register1, Register register2, Register register3) {
    }

    @Override

    public String convertToBinary() {
        return "0000010000000000";
    }
}
