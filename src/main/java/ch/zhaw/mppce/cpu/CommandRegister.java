package ch.zhaw.mppce.cpu;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 15.10.12
 * Time: 21:17
 */
public class CommandRegister extends Register {
    ArrayList<String> commandRegister;

    public CommandRegister() {
        commandRegister = new ArrayList<String>();
    }

    public ArrayList<String> getCommandRegister() {
        return commandRegister;
    }

    public void addCommand(String command) {
        commandRegister.add(command);
    }

    // Display the whole command register
    public void printCommandRegister() {
        for (String command : getCommandRegister()) {
            System.out.println("CR: " + command);
        }
    }
}
