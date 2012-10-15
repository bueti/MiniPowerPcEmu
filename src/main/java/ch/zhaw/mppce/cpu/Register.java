package ch.zhaw.mppce.cpu;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:49
 */
public class Register {
    // Instance Variables
    private ArrayList<String> register;

    // Constructor
    public Register() {
        register = new ArrayList<String>();
        register.add("0000000000000000");
    }

    // Getter & Setter
    public ArrayList<String> getRegister() {
        return register;
    }

    public void setRegister(ArrayList<String> register) {
        this.register = register;
    }

    // Return value at position i or 0 if register is empty
    public String getValue(int i) {
        return register.get(i);
    }

    // Save Binary Command to Command Register
    public void storeCommand(String command) {
        register.add(command);
    }

    public void setValue(int i, String value) {
        register.set(i, value);
    }
}
