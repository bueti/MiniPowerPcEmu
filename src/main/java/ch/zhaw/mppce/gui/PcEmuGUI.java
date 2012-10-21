package ch.zhaw.mppce.gui;

import ch.zhaw.mppce.Emulator;
import ch.zhaw.mppce.cpu.CPU;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PcEmuGUI {
    // Intanzvariablen GUI
    private static JFrame frame;
    private CPU cpu;
    private File programFile;
    private static PcEmuGUI gui;


    // Konstruktor
    public PcEmuGUI(CPU cpu) {
        this.cpu = cpu;
        this.gui = this;
        emugui();
    }


    public void emugui() {
        frame = new JFrame("Mini Power PC Emulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JTextArea operate = new JTextArea();
        operate.setLineWrap(true);
        operate.setWrapStyleWord(true);
        operate.setBackground(Color.WHITE);
        operate.setFont(new Font("SansSerif", Font.PLAIN, 11));
        operate.setEditable(false);
        JTextArea prgmMem = new JTextArea();
        prgmMem.setLineWrap(true);
        prgmMem.setWrapStyleWord(true);
        prgmMem.setBackground(Color.WHITE);
        prgmMem.setFont(new Font("SansSerif", Font.PLAIN, 11));
        prgmMem.setEditable(false);
        JTextArea dataMem = new JTextArea();
        dataMem.setLineWrap(true);
        dataMem.setWrapStyleWord(true);
        dataMem.setBackground(Color.WHITE);
        dataMem.setFont(new Font("SansSerif", Font.PLAIN, 11));
        dataMem.setEditable(false);
        JTextArea register = new JTextArea();
        register.setLineWrap(true);
        register.setWrapStyleWord(true);
        register.setBackground(Color.WHITE);
        register.setFont(new Font("SansSerif", Font.PLAIN, 11));
        register.setEditable(false);
        JTextArea akku = new JTextArea();
        akku.setLineWrap(true);
        akku.setWrapStyleWord(true);
        akku.setBackground(Color.WHITE);
        akku.setFont(new Font("SansSerif", Font.PLAIN, 11));
        akku.setEditable(false);
        JTextArea befRegister = new JTextArea();
        befRegister.setLineWrap(true);
        befRegister.setWrapStyleWord(true);
        befRegister.setBackground(Color.WHITE);
        befRegister.setFont(new Font("SansSerif", Font.PLAIN, 11));
        befRegister.setEditable(false);
        JTextField param1 = new JTextField(8);
        JTextField param2 = new JTextField(8);
        JLabel eingabeparam = new JLabel("Eingabeparameter");

        // Buttons erstellen
        JButton load = new JButton("Load File");
        load.addActionListener(new LoadActionListener());
        JButton slow = new JButton("Slow");
        slow.addActionListener(new SlowActionListener());
        JButton fast = new JButton("Fast");
        fast.addActionListener(new FastActionListener());

        // Linke Seite GUI erstellen
        left.setLayout(new BorderLayout());

        left.add(operate, BorderLayout.NORTH);
        JPanel button = new JPanel();
        button.setLayout(new FlowLayout(FlowLayout.CENTER));
        button.add(load);
        button.add(slow);
        button.add(fast);
        left.add(button, BorderLayout.SOUTH);

        // Rechte Seite GUI erstellen
        right.setLayout(new BorderLayout());
        JPanel rightnorth = new JPanel();
        rightnorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        rightnorth.add(prgmMem);
        rightnorth.add(dataMem);
        JPanel rightcenter = new JPanel();
        rightcenter.setLayout(new BorderLayout());
        rightcenter.add(register, BorderLayout.NORTH);
        rightcenter.add(akku, BorderLayout.SOUTH);
        JPanel rightsouth = new JPanel();
        rightsouth.setLayout(new BorderLayout());
        rightsouth.add(befRegister, BorderLayout.NORTH);
        rightsouth.add(eingabeparam, BorderLayout.CENTER);
        right.add(rightnorth, BorderLayout.NORTH);
        right.add(rightcenter, BorderLayout.CENTER);
        right.add(rightsouth, BorderLayout.SOUTH);
        JPanel parameter = new JPanel();
        parameter.setLayout(new FlowLayout(FlowLayout.CENTER));
        parameter.add(param1);
        parameter.add(param2);
        rightsouth.add(parameter, BorderLayout.SOUTH);
        frame.getContentPane().add(left, BorderLayout.WEST);
        frame.getContentPane().add(right, BorderLayout.CENTER);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public File getProgramFile() {
        return programFile;
    }

    // Innere Klassen für Actionlistener

    private class LoadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Mini PowerPC File Loader");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setApproveButtonText("Choose File");
            fc.setFileFilter(new FileNameExtensionFilter("Assembler (*.asm)", "asm"));
            int returnVal = fc.showOpenDialog(new JFrame());

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                programFile = fc.getSelectedFile();
            }

            FileLoader fl = new FileLoader();
            fl.parseFile(cpu, gui);

            // Print Command Register, TODO: move this into the gui
            for (String command : cpu.showCommandRegister()) {
                System.out.println("CR: " + command);
            }
        }
    }

    private class SlowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //todo
        }
    }

    private class FastActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run();
        }
    }


}
