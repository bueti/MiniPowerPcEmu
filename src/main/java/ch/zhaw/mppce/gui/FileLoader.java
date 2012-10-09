package ch.zhaw.mppce.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public List<String> loadFile(String file) throws IOException, ClassNotFoundException{
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
