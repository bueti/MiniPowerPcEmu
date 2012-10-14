package ch.zhaw.mppce.tools;

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
}
