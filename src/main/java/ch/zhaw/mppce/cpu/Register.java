package ch.zhaw.mppce.cpu;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:49
 */
public class Register {
    private String[] register;

    public Register() {
        register = new String[1];
        addToRegister("0000000000000000");
    }

    public String getRegister() {
        return register[0];
    }

    public void setRegister(String register) {
        this.register[0] = register;
    }

    public void addToRegister(String value) {
        register[0] = value;
    }

    public void setCarryBit() {
        String carryBit = register[0].substring(0, 0) + '1' + register[0].substring(2);
        register[0] = carryBit;
    }

//    // Instance Variables
//    private ArrayList<String> register;
//
//    // Constructor
//    public Register() {
//        register = new ArrayList<String>();
//        register.add("0000000000000000");
//    }
//
//    // Getter & Setter
//    public ArrayList<String> getRegister() {
//        return register;
//    }
//
//    public void setRegister(ArrayList<String> register) {
//        this.register = register;
//    }
//
//    // Return value at position i or 0 if register is empty
//    public String getValue(int i) {
//        return register.get(i);
//    }
//
//    // Save Binary Command to Command Register
//    public void storeCommand(String command) {
//        register.add(command);
//    }
//
//    public void setValue(int i, String value) {
//        register.set(i, value);
//    }
//

}
