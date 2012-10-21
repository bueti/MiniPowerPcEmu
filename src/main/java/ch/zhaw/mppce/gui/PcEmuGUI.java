package ch.zhaw.mppce.gui;

import ch.zhaw.mppce.cpu.CPU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PcEmuGUI {
    // Intanzvariablen GUI
    private static JFrame frame;
    private CPU cpu;


    // Konstruktor
    public PcEmuGUI(CPU cpu) {
        this.cpu = cpu;
        emugui();
    }


    public void emugui() {
        frame = new JFrame("Mini Power PC Emulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JTextArea operate = new JTextArea();
        JTextArea prgmMem = new JTextArea();
        JTextArea dataMem = new JTextArea();
        JTextArea register = new JTextArea();
        JTextArea akku = new JTextArea();
        JTextArea befRegister = new JTextArea();
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

        // Zugriff auf die CPU - Text darstellen sollte ungefähr so gehen
        for (String command : cpu.showCommandRegister()) {
            befRegister.setText(command);
        }
    }

    // Innere Klassen für Actionlistener

    private class LoadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //todo
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
            //todo
        }
    }


}
