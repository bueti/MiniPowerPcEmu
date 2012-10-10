package ch.zhaw.mppce;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.gui.FileLoader;import ch.zhaw.mppce.gui.FileParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            // Store address
            // Store code
            // Store params
        }


        // Run Program

    }


}
