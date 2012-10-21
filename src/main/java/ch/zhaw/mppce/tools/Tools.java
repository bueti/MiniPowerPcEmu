package ch.zhaw.mppce.tools;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Register;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 14.10.12
 * Time: 17:47
 */
public class Tools {

    // Takes a two's complement binary string and returns a decimal int
    public int convertToDec(String binary) {
        final boolean minus = binary.charAt(0) == '1';
        final String value = binary.substring(1);
        if (minus) {
            return (int) -(Math.pow(2, value.length()) - Math.abs(Integer.parseInt(value, 2)));
        } else {
            return Integer.parseInt(value, 2);
        }
    }

    // Takes a decimal int and returns a two's complement i bit string
    public String convertToBin(int value, int i) {
        String a = Integer.toBinaryString(value & 0xFFFF);

        return String.format("%" + i + "s", a).replace(' ', '0');
    }

    public Register getRegisterFromParams(CPU cpu, String params) {
        String register = params.replace(",", " ").split(" ")[1].trim().replaceAll("[^\\d]", "");

        if (register.equals("0")) {
            return cpu.getAccu();
        } else if (register.equals("1")) {
            return cpu.getRegister1();
        } else if (register.equals("2")) {
            return cpu.getRegister2();
        } else if (register.equals("3")) {
            return cpu.getRegister3();
        } else {
            System.out.println("Register Nr " + register + " not known.");
            return null;
        }
    }

    public int getAddressFromParams(String params) {
        if (params.contains(",")) {
            String address = params.split(",")[1].trim().replaceAll("[^\\d]", "");
            return Integer.parseInt(address);
        } else if (params.contains(" ")) {
            String address = params.split(" ")[1].trim().replaceAll("[^\\d]", "");
            return Integer.parseInt(address);
        } else {
            System.out.println("Don't know how to handle " + params);
            return 0;
        }
    }

    public String getValueFromParams(int i, String params) {
        return params.replace(",", " ").split(" ")[i].trim().replaceAll("[^\\d]", "");
    }

}
