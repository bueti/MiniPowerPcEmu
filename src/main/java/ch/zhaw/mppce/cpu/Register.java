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
        setRegister(new ArrayList<String>());

    }

    // Getter & Setter
    public ArrayList<String> getRegister() {
        return register;
    }

    public void setRegister(ArrayList<String> register) {
        this.register = register;
    }

    public String getValue() {
        return register.get(0);
    }
}
