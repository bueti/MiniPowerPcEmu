package ch.zhaw.mppce;

import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.gui.PcEmuGUI;

/**
 * Created with IntelliJ IDEA.
 * User: bbu
 * Date: 07.10.12
 * Time: 16:23
 */
public class AppStarter {

    public static void main(String[] args) {
        // Initialize CPU
        CPU cpu = new CPU();

        // Initialize GUI
        PcEmuGUI gui = new PcEmuGUI(cpu);

    }

}
