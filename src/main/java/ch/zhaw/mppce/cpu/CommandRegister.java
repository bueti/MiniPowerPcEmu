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

    public String getCommandRegisterAsString() {
        StringBuilder sb = new StringBuilder();
        for(String command : commandRegister) {
            sb.append(command);
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
