package ch.zhaw.mppce.cpu;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:49
 */
public class Accumulator extends Register {
    private String[] accu;

    public Accumulator() {
        accu = new String[1];
        addToAccu("0000000000000000");
    }

    public String getAccu() {
        return accu[0];
    }

    public void setAccu(String accu) {
        this.accu[0] = accu;
    }

    public void addToAccu(String value) {
        accu[0] = value;
    }
}
