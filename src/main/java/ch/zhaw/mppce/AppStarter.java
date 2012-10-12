package ch.zhaw.mppce;

import ch.zhaw.mppce.compiler.instructions.Instruction;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.gui.FileLoader;
import ch.zhaw.mppce.gui.FileParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
            //command = prefix + command;
            if(parsedLine[1].equals("ADD")) {
                Class cl = null;
                Instruction newCommand;
                try {
                    cl = Class.forName("ch.zhaw.mppce.compiler.instructions." + parsedLine[1]);
                    java.lang.reflect.Constructor co = cl.getConstructor();
                    newCommand = (Instruction) co.newInstance(null);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (InvocationTargetException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (InstantiationException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }


            }
            //Instruction instr = new Instruction(parsedLine[1], parsedLine[2]);
            //cpu.addCommandToProgramMemory(Integer.parseInt(parsedLine[0]), instr);
        }


        // Convert Mnemonics to Binary
        //for(Instruction instr : cpu.getProgramMemory()) {
            //instr.convertToBinary(instr);

            //String simpleClassName = instr[1].getSimpleName();
        //}

    }

}
