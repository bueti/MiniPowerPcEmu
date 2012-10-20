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


    public boolean hasCarryBit() {
        if (register[0].substring(1, 1).equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}
