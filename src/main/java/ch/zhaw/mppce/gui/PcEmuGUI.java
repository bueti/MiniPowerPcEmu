package ch.zhaw.mppce.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PcEmuGUI {

	
	
	
	
	// Intanzvariablen GUI
	private static JFrame frame;

	
	// Konstruktor
	public PcEmuGUI() {
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
		JTextArea register	= new JTextArea();
		JTextArea akku = new JTextArea();
		JTextArea befRegister = new JTextArea();
		
		
		JButton load = new JButton("Load File");
		load.addActionListener(new LoadActionListener());
		JButton slow = new JButton("Slow");
		slow.addActionListener(new SlowActionListener());
		JButton fast = new JButton("Fast");
		fast.addActionListener(new FastActionListener());
		
		left.setLayout(new BorderLayout());
		
		left.add(operate, BorderLayout.NORTH);
		left.add(load, BorderLayout.SOUTH);
		left.add(slow, BorderLayout.SOUTH);
		left.add(fast, BorderLayout.SOUTH);
		
		right.add(prgmMem, BorderLayout.NORTH);
		right.add(dataMem, BorderLayout.NORTH);
		right.add(register, BorderLayout.CENTER);
		right.add(akku, BorderLayout.CENTER);
		right.add(befRegister, BorderLayout.SOUTH);
		frame.getContentPane().add(BorderLayout.WEST, left);
		frame.getContentPane().add(BorderLayout.EAST, right);
		
		frame.setSize(500,500);
		frame.setVisible(true);
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
