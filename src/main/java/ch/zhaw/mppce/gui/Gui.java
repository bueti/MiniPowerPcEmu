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
    private JTextArea dMemoryArea;
    private JTextArea pMemoryArea;
    private JTextArea commandArea;

    // Scrollbars
    private JScrollPane dMemoryScroll;
    private JScrollPane pMemoryScroll;
    private JScrollPane commandRegScroll;

    // Textfields
    private JTextField accuField;
    private JTextField register1Field;
    private JTextField register2Field;
    private JTextField register3Field;
    // Input
    private JLabel inputLabel;
    private JTextField input1Field;
    private JTextField input2Field;

    // Labels
    private JLabel accuLabel;
    private JLabel register1Label;
    private JLabel register2Label;
    private JLabel register3Label;
    private JLabel counterLabel;
    private JTextField counterField;
    private JCheckBox chckbxCarryBit;

    // Constructor
    public Gui(CPU cpu) {
        this.cpu = cpu;
        this.gui = this;
        init();
    }

    // Methods
    private void init() {
        frame = new JFrame("Mini PowerPC Emulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        createMenubar();

        // Create Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 6));

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
        centerPanel.setLayout(new GridLayout(0, 4));

        // Create Register Panel
        registerPanel = new JPanel();

        // Registers
        accuField = new JTextField(16);
        accuLabel = new JLabel("Accu: ");
        register1Field = new JTextField(16);
        register1Label = new JLabel("Reg1: ");
        register2Field = new JTextField(16);
        register2Label = new JLabel("Reg2: ");
        register3Field = new JTextField(16);
        register3Label = new JLabel("Reg3: ");

        accuField.setEditable(false);
        register1Field.setEditable(false);
        register2Field.setEditable(false);
        register3Field.setEditable(false);

        centerPanel.add(registerPanel);
        registerPanel.setLayout(null);

        accuLabel.setBounds(6, 6, 45, 16);
        registerPanel.add(accuLabel);

        accuField.setBounds(60, 0, 134, 28);
        registerPanel.add(accuField);
        accuField.setColumns(10);

        register1Label.setBounds(6, 34, 61, 16);
        registerPanel.add(register1Label);

        register2Label.setBounds(6, 62, 61, 16);
        registerPanel.add(register2Label);

        register3Label.setBounds(6, 90, 61, 16);
        registerPanel.add(register3Label);

        register1Field.setBounds(60, 28, 134, 28);
        registerPanel.add(register1Field);
        register1Field.setColumns(10);

        register2Field.setBounds(60, 56, 134, 28);
        registerPanel.add(register2Field);
        register2Field.setColumns(10);

        register3Field.setBounds(60, 84, 134, 28);
        registerPanel.add(register3Field);
        register3Field.setColumns(10);

        counterLabel = new JLabel("Counter:");
        counterLabel.setBounds(6, 118, 61, 16);
        registerPanel.add(counterLabel);

        counterField = new JTextField();
        counterField.setBounds(60, 112, 134, 28);
        registerPanel.add(counterField);
        counterField.setColumns(10);
        counterField.setEditable(false);

        chckbxCarryBit = new JCheckBox("Carry Bit?");
        chckbxCarryBit.setBounds(6, 145, 128, 23);
        registerPanel.add(chckbxCarryBit);

        // Create Data Panel
        dMemoryPanel = new JPanel();
        dMemoryPanel.setLayout(new BorderLayout());

        dMemoryArea = new JTextArea();
        dMemoryPanel.add(dMemoryArea);
        dMemoryArea.setText("Data Memory");
        dMemoryScroll = new JScrollPane(dMemoryArea);

        centerPanel.add(dMemoryScroll);

        // Create Memory Panel
        pMemoryPanel = new JPanel();
        pMemoryPanel.setLayout(new BorderLayout());

        pMemoryArea = new JTextArea();
        pMemoryPanel.add(pMemoryArea);
        pMemoryArea.setText("Program Memory");
        pMemoryScroll = new JScrollPane(pMemoryArea);

        centerPanel.add(pMemoryScroll);

        // Create Command Register Panel
        commandPanel = new JPanel();
        commandPanel.setLayout(new BorderLayout());

        commandArea = new JTextArea();
        commandPanel.add(commandArea);
        commandArea.setText("Command Register");
        commandRegScroll = new JScrollPane(commandArea);

        centerPanel.add(commandRegScroll);

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

    // Getter & Setter
    public File getProgramFile() {
        return programFile;
    }

    public void setdMemoryArea(String mem) {
        dMemoryArea.setText(mem);
    }

    public void setpMemoryArea(String mem) {
        pMemoryArea.setText(mem);
    }

    // this could be done with one method
    public void setRegister1Field(String reg) {
        register1Field.setText(reg);
    }

    public void setRegister2Field(String reg) {
        register2Field.setText(reg);
    }

    public void setRegister3Field(String reg) {
        register3Field.setText(reg);
    }

    public void setCommandArea(String commands) {
        commandArea.setText(commands);
    }

    public void setAccuField(String accu) {
        accuField.setText(accu);
    }

    public void setCounterField(int counter) {
        counterField.setText(Integer.toString(counter));
    }

    public void displayCarryBit(boolean carry) {
        chckbxCarryBit.enable(carry);
    }

    // Inner Classes
    private class FastActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run("fast");
        }
    }

    private class SlowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run("slow");
        }
    }

    private class StepActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create Emulator
            Emulator emu = new Emulator(cpu, gui);
            emu.run("step");
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
            setdMemoryArea(dataMemory.getDataMemoryAsString());
        }
    }
}
