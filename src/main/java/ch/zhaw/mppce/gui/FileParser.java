package ch.zhaw.mppce.gui;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 09.10.12
 * Time: 21:46
 *
 * Parses the program and saves it into the ProgramMemory
 *
 */
public class FileParser {
    public FileParser(List<String> program) {
        parseFile(program);
    }

    private void parseFile(List<String> program) {
        String[] delim;

        for(String line : program) {

            // Remove Comments
            delim = line.split(";");
            String restOfLine = delim[0];

            // Get Address
            delim = restOfLine.split(" ");
            int address = Integer.parseInt( delim[0] );

            // Get Command
            String command = delim[1];

            // Get Parameters
            String[] params;

            // Store in memory

            System.out.println(address + " " + command);
        }
    }

}
