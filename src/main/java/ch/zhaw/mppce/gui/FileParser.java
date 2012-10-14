package ch.zhaw.mppce.gui;

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

    public String[] parseLine(String line) {
        String[] parsedLine = new String[5];
        String[] delim = null;

        // Remove Comments
        delim = line.split(";");
        String restOfLine = delim[0];

        // Get Address
        delim = restOfLine.split(" ");
        parsedLine[0] = delim[0];

        // Get Command
        parsedLine[1] = delim[1];

        // Get Parameters
        if(delim.length > 2) {
            String params = null;
            int i = 2;
            while(i<delim.length) {
                params = params + " " + delim[i];
                i++;
            }
            parsedLine[2] = params;
        } else {
            parsedLine[0] = delim[0];
            parsedLine[1] = delim[1];
        }

        // Return line
        return parsedLine;


    }

}
