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

    public int parseSignedInt(final String binary) {
        final boolean minus = binary.charAt(0) == '1';
        final String value = binary.substring(1);
        if (minus) {
            return (int) -(Math.pow(2, value.length()) - Math.abs(Integer.parseInt(value, 2)));
        } else {
            return Integer.parseInt(value, 2);
        }
    }

    public String makeTwosComplement(final String binary) {
        if (binary.equals("0")) {
            return "0000000000000000";
        }

        final boolean minus = binary.charAt(0) == '1';
        final String value = binary.substring(1);
        if (minus) {
            int i = (int) -(Math.pow(2, value.length()) - Math.abs(Integer.parseInt(value, 2)));
            String zahl = null;
            zahl = zahl.format("%2s", Integer.toBinaryString(i)).replace(' ', '0');
            return zahl;
        } else {
            int i = Integer.parseInt(value, 2);
            String zahl = null;
            zahl = zahl.format("%2s", Integer.toBinaryString(i)).replace(' ', '0');
            return zahl;
        }
    }

    public String convertToBin(int value) {
        char[] array = new char[16];
        String valString = String.valueOf(value);
        // TODO: TEST
//        final String rvalue = valString.substring(2);
//        if (rvalue.equals("")) {
//            value = 0;
//        } else {
//            value = Integer.parseInt(rvalue);
//        }

        for (int i = 0; i < 16; i++) {
            if (value % 2 == 0)
                array[15 - i] = '0';
            else if (value % 2 == 1)
                array[15 - i] = '1';
            value = value / 2;
        }
        if (valString.contains("-")) {
            String converted = new String(array);
            return converted.replaceFirst("0", "1");
        }
        return new String(array);
    }

    public Register getRegisterFromParams(String params) {
        String register = params.replaceAll("[^\\d]", "");
        if (register.equals("1")) {
            return CPU.getRegister1();
        } else if (register.equals("2")) {
            return CPU.getRegister2();
        } else {
            return CPU.getRegister3();
        }
    }

    public int getAddressFromParams(String params) {
        String address = params.split(",")[1].trim().replaceAll("[^\\d]", "");
        return Integer.parseInt(address);
    }

    // TODO: Convert Binary String to Two's Complemet
    public String convertBinToTwosComplement(String result) {
        return "0000000000000000";
    }

    // this function converts a decimal number into two's complement
    // Geklaut vom Domo, Danke ;-)
    public String twoComplement(int x) {

        if (x < 0) {
            String string = Integer.toString(x);
            String dec = convertToBin(Integer.parseInt(string.substring(1)));
            String invertstr = "";
            for (int i = 0; i < dec.length(); i++) {

                if (Integer.parseInt(dec.substring(i, i + 1)) == 1) {
                    invertstr = invertstr + "0";
                } else {
                    invertstr = invertstr + "1";
                }
            }
            // if last sign == 0 then just replace it by a 1
            if (invertstr.substring(invertstr.length() - 1).equals(0)) {
                return invertstr.substring(0, invertstr.length() - 1) + "1";
            } else {
                // add in decimal system 1 and convert back to binary
                int res = Integer.parseInt(invertstr, 2) + 1;
                return Integer.toString(res);
            }

        } else {
            return convertToBin(x);
        }

    }
}
