package ch.zhaw.mppce.gui;

import ch.zhaw.mppce.Emulator;
import ch.zhaw.mppce.cpu.CPU;
import ch.zhaw.mppce.cpu.Memory;
import ch.zhaw.mppce.tools.Tools;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: bbuetikofer
 * Date: 22/10/12
 * Time: 10:45
 */
public class Gui {

    // Instanzvariablen
    private CPU cpu;
    private static Gui gui;
    private File programFile;

    // Gui Variablen
    private static JFrame frame;
    private JPanel centerPanel;
    private JPanel registerPanel;
    private JPanel pMemoryPanel;
    private JPanel dMemoryPanel;
    private JPanel buttonPanel;
    private JPanel commandPanel;

    // Buttons
    private JButton fastButton;
    private JButton slowButton;
    private JButton stepButton;

    // Text Areas
    private JTextArea registerArea;
    private JTextArea dMemoryArea;
    private JTextArea pMemoryArea;
    private JTextArea commandArea;

    // Input
    private JLabel inputLabel;
    private JTextField input1Field;
    private JTextField input2Field;


    // Constructor

    public Gui(CPU cpu) {
        this.cpu = cpu;
        this.gui = this;
        init();
    }

    private void init() {
        frame = new JFrame("Mini PowerPC Emulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        createMenubar();

        // Create Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,6));

        fastButton = new JButton("Fast");
        fastButton.addActionListener(new FastActionListener());
        buttonPanel.add(fastButton);

        slowButton = new JButton("Slow");
        slowButton.addActionListener(new SlowActionListener());
        buttonPanel.add(slowButton);

        stepButton = new JButton("Step");
        stepButton.addActionListener(new StepActionListener());
        buttonPanel.add(stepButton);

        inputLabel = new JLabel("Input: ");
        input1Field = new JTextField(6);
        input1Field.setText("");
        input1Field.addActionListener(new Input1ActionListener());
        input2Field = new JTextField(6);
        input2Field.setText("");
        input2Field.addActionListener(new Input2ActionListener());
        buttonPanel.add(inputLabel);
        buttonPanel.add(input1Field);
        buttonPanel.add(input2Field);
        fastButton.setEnabled(false);
        slowButton.setEnabled(false);
        stepButton.setEnabled(false);

        // Add Button Panel to Main Panel
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Create center panel which is holding the register and memory
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0,4));

        // Create Register Panel
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4,0));

        // TODO: Split Register1-3 + Accu
        registerArea = new JTextArea();
        registerPanel.add(registerArea);
        registerArea.setText("Register");

        centerPanel.add(registerPanel);

        // Create Data Panel
        dMemoryPanel = new JPanel();
        dMemoryPanel.setLayout(new BorderLayout());

        dMemoryArea = new JTextArea();
        dMemoryPanel.add(dMemoryArea);
        dMemoryArea.setText("Data Memory");

        centerPanel.add(dMemoryPanel);

        // Create Memory Panel
        pMemoryPanel = new JPanel();
        pMemoryPanel.setLayout(new BorderLayout());

        pMemoryArea = new JTextArea();
        pMemoryPanel.add(pMemoryArea);
        pMemoryArea.setText("Program Memory");

        centerPanel.add(pMemoryPanel);

        // Create Command Register Panel
        commandPanel = new JPanel();
        commandPanel.setLayout(new BorderLayout());

        commandArea = new JTextArea();
        commandPanel.add(commandArea);
        commandArea.setText("Command Register");

        centerPanel.add(commandArea);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        frame.setSize(800, 500);
        frame.setVisible(true);

    }

    private void createMenubar() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener((new LoadActionListener()));
        file.add(open);
        bar.add(file);
        frame.setJMenuBar(bar);
    }

    private void loadFile() {
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
        String commands = fl.parseFile(cpu, gui);

        // Print Command Register
        commandArea.setText(commands);

        // Enable Buttons
        fastButton.setEnabled(true);
        slowButton.setEnabled(true);
        stepButton.setEnabled(true);
    }

    public File getProgramFile() {
        return programFile;
    }

    // Inner Classes
    private class FastActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run();
        }
    }

    private class SlowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run();
        }
    }

    private class StepActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run();
        }
    }

    private class LoadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Load file
            loadFile();
        }
    }

    private class Input1ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Get Value
            String input1 = input1Field.getText();

            // Convert to twos complement
            Tools tools = new Tools();
            String inputBin = tools.convertToBin(Integer.valueOf(input1), 16);

            // Store into DataMemory (+ 1)
            // Split into two 8 bit strings
            String val1 = inputBin.substring(0, 8);
            String val2 = inputBin.substring(8);

            Memory dataMemory = cpu.getDataMemory();
            dataMemory.setValue(500, val2);
            dataMemory.setValue(501, val1);
        }
    }

    private class Input2ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Get Value
            String input2 = input2Field.getText();
            int input2Dec = Integer.valueOf(input2);

            // Convert to twos complement
            Tools tools = new Tools();
            String inputBin = tools.convertToBin(input2Dec, 16);

            // Store into DataMemory (+ 1)
            // Split into two 8 bit strings
            String val1 = inputBin.substring(0, 8);
            String val2 = inputBin.substring(8);

            Memory dataMemory = cpu.getDataMemory();
            dataMemory.setValue(502, val2);
            dataMemory.setValue(503, val1);

            // Get DataMemory data
            dMemoryArea.setText(dataMemory.getDataMemoryAsString());
        }
    }
}
