package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.gui.FileLoader;
import ch.zhaw.mppce.gui.FileParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 16:23
 */
public class AppStarter {

    public static void main(String[] args) {
        // CPU
        CPU cpu = new CPU();

        // Load file
        FileLoader fl = new FileLoader();
        List<String> program = new ArrayList<String>();

        try {
            program = fl.loadFile("/var/tmp/test");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Parse file
        FileParser fp = new FileParser();
        for(String line : program) {
            String[] parsedLine = fp.parseLine(line);

            // Store address, Store code
            Instruction instr = new Instruction(parsedLine[1], parsedLine[2]);
            cpu.addCommandToProgramMemory(Integer.parseInt(parsedLine[0]), instr);

            // Store params
        }

        // Run Program
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
