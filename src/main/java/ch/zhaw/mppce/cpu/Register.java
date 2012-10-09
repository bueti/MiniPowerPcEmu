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
    private ArrayList<Integer> register;

    // Constructor
    public Register() {
        setRegister(new ArrayList<Integer>());

    }

    // Getter & Setter
    public ArrayList<Integer> getRegister() {
        return register;
    }

    public void setRegister(ArrayList<Integer> register) {
        this.register = register;
    }
}
