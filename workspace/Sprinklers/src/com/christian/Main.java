package com.christian;

import java.awt.GridLayout;

import java.io.IOException;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	Main parent;
	
	
	JPanel window;
	JTextField display;
	JButton send;	
	JPanel p1;
	
	
	
	Main(Networking net){
		window = new JPanel();
		
		display = new JTextField(30);
		window.add("North", display);
		send = new JButton("send");
		
		
		
		SprinklerEngine engine = new SprinklerEngine(this,net);
		
		
		display.setText("Command:");
		
		send.addActionListener(engine);
		
		p1 = new JPanel();
		
		GridLayout gl = new GridLayout();
		p1.setLayout(gl);
		
		
		p1.add(send);
		
		window.add("Center",p1);
		
		JFrame frame = new JFrame("Christian's Sprinkler Pi Program!");
		frame.setContentPane(window);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Networking net = new Networking("localhost", 42001);
			Main main = new Main(net);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Oh noes! IOException: "+e);
		}
	
	}
	
	
	public String getText(){
		System.out.println(display.getText());
		return display.getText();
		
	}


}
