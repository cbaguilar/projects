package com.christian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SprinklerEngine implements ActionListener{
	
	Main parent;
	
	SprinklerEngine(Main parent){
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		 JButton clickedBytton = (JButton) e.getSource();
		 
		 System.out.println("test");
		 
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