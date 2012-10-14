package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.gui.FileLoader;
import ch.zhaw.mppce.gui.FileParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 16:23
 */
public class AppStarter {

    public static void main(String[] args) {
        // cpu
        CPU cpu = new CPU();

        // Load file
        FileLoader flp = new FileLoader();
        FileLoader fld = new FileLoader();
        List<String> program = new ArrayList<String>();
        List<String> data = new ArrayList<String>();

        try {
            program = flp.loadFile("/var/tmp/test");
            data = fld.loadFile("/var/tmp/test2");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Load Assembler File
        FileParser fp = new FileParser();
        for(String line : program) {
            String[] parsedLine = fp.parseLine(line);

            // Store address, Store code
            Class cl = null;
            Instruction instr = null;
            try {
                cl = Class.forName("ch.zhaw.mppce.compiler.instructions." + parsedLine[1]);

                if(parsedLine[2] != null) {
                    instr =(Instruction) cl.getConstructor(String.class).newInstance(parsedLine[2]);
                } else {
                    java.lang.reflect.Constructor co = cl.getConstructor(null);
                    instr = (Instruction) co.newInstance(null);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Instruction " + parsedLine[1] + " not implemented yet");
                //e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            // Save Instruction to program memory
            cpu.addCommandToMemory(parsedLine[0], instr);
        }

        // Load Data File
        for(String line : data ) {
            String[] parsedLine = fp.parseLine(line);
            cpu.addCommandToMemory(parsedLine[0], parsedLine[1]);
        }

        // Convert Mnemonics to Binary
        HashMap<String, Instruction> programMemory = cpu.getProgramMemory();

        for (Map.Entry<String, Instruction> entry : programMemory.entrySet()) {
            String key = entry.getKey();
            Instruction instr = entry.getValue();
            if(instr != null) {
                System.out.println(instr.convertToBinary());
                // TODO: Save to command register
                System.out.println("doit: " + instr.doIt());
            }

        }

        // TODO: Save converted commands into command register

        // Run that shit


    }

}
