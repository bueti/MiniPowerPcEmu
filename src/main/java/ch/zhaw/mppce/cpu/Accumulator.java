package ch.zhaw.mppce.cpu;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 15:49
 */
public class Accumulator extends Register {
    private ArrayList<String> accu;

    public Accumulator() {
        setAccu(new ArrayList<String>());
    }

    public ArrayList<String> getAccu() {
        return accu;
    }

    public void setAccu(ArrayList<String> accu) {
        this.accu = accu;
    }
}
