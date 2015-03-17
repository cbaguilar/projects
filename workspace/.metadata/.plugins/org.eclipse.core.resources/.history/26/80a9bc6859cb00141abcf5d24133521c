package com.christian;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	Main parent;
	
	
	JPanel window;
	JTextField display;
	JButton send;
	JPanel p1;
	Main(){
		window = new JPanel();
		BorderLayout bl = new BorderLayout();
		display = new JTextField(30);
		window.add("North", display);
		send = new JButton("send");
		SprinklerEngine engine = new SprinklerEngine(parent);
		
		send.addActionListener(engine);
		
		p1 = new JPanel();
		
		GridLayout gl = new GridLayout();
		p1.setLayout(gl);
		
		
		p1.add(send);
		
		window.add("Center",p1);
		
		JFrame frame = new JFrame("Sprinklers");
		frame.setContentPane(window);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main calc = new Main();
		System.out.println("derp");
	}

	
}
