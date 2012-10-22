package ch.zhaw.mppce.gui;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 21:18
 */
public class FileLoader {

    public FileLoader() {
    }

    public String parseFile(CPU cpu, Gui gui) {
        // Load Data and Program file. This will later be handled by the GUI.
        // The Data File will probably not be used anymore and as we enter the data
        // directly via the GUI. The Program File will always be loaded via the GUI.
        FileLoader fl = new FileLoader();
        List<String> program = new ArrayList<String>();
        List<String> data = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        try {
            program = fl.readFile(gui.getProgramFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create File Parser
        FileParser fp = new FileParser();

        // Load Assembler File
        for (String line : program) {
            String[] parsedLine = fp.parseLine(line);
            sb.append(line);
            sb.append(System.getProperty("line.separator"));

            // Store address, Store code
            Class cl = null;
            Instruction instr = null;
            try {
                cl = Class.forName("ch.zhaw.mppce.compiler.instructions." + parsedLine[1]);

                if (parsedLine[2] != null) {
                    instr = (Instruction) cl.getConstructor(String.class).newInstance(parsedLine[2]);
                } else {
                    java.lang.reflect.Constructor co = cl.getConstructor();
                    instr = (Instruction) co.newInstance();
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

            // Convert Mnemonics to binary and store it
            Memory memory = cpu.getProgramMemory();
            memory.convertMnemonics2Binary(cpu);
        }
        return sb.toString();
    }

    public List<String> readFile(File file) throws IOException, ClassNotFoundException {
        BufferedReader reader = null;
        try {
            List<String> commands = new ArrayList<String>();
            reader = new BufferedReader(new FileReader(file));

            String command = reader.readLine();
            while (command != null) {
                commands.add(command);
                command = reader.readLine();
            }
            return commands;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}
