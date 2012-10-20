package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.gui.FileLoader;
import ch.zhaw.mppce.gui.FileParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
        // Initialize CPU
        CPU cpu = new CPU();


        // Load files
        FileLoader fl = new FileLoader();
        List<String> program = new ArrayList<String>();
        List<String> data = new ArrayList<String>();

        try {
            program = fl.loadFile("~/Roland/Informatik3/MiniPcEmulator/bsp1.asm");
            data = fl.loadFile("~/Roland/Informatik3/MiniPcEmulator/bsp1.data");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create File Parser
        FileParser fp = new FileParser();
        
        // Load Data File
        for (String line : data) {
            String[] parsedLine = fp.parseLine(line);
            // Save command to data memory
            cpu.addCommandToMemory(parsedLine[0], parsedLine[1]);
        }

        // Load Assembler File
        for (String line : program) {
            String[] parsedLine = fp.parseLine(line);

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
        }

        // Convert Mnemonics to binary and store it
        Memory memory = cpu.getProgramMemory();
        memory.convertMnemonics2Binary(cpu);

        // Print Command Register
        cpu.printCommandRegister();

        // Create Emulator
        Emulator emu = new Emulator(cpu);
        emu.run();
    }

}
