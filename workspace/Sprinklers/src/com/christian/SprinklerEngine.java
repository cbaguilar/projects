package com.christian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SprinklerEngine implements ActionListener{
	
	Main parent;
	Networking net;
	
	SprinklerEngine(Main parent, Networking net){
		this.parent = parent;
		System.out.println(parent);
		this.net = net;
		System.out.println("xonstructed");
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		 JButton clickedButton = (JButton) e.getSource();
		 
		 if (clickedButton == parent.send){
			 net.send(parent.getText());
		 }
		 
		
		 
		 
			
		 
		 
		 
		 /*Object src = e.getSource();
		 System.out.println("derp");
		 if (src == parent.send){
			 System.out.println("send");
		 }
		 */
		 //String clickedButtonLabel = clickedButton.getText();
		 
		 
		// JOptionPane.showConfirmDialog(null,
			//	 "You just pressed"+clickedButtonLabel,
			//	 "test:",JOptionPane.PLAIN_MESSAGE);
		 	
	}

	}