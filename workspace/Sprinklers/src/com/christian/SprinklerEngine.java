package com.christian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class SprinklerEngine implements ActionListener{
	
	Main parent;
	Networking net;
	
	SprinklerEngine(Main parent){
		this.parent = parent;
		System.out.println(parent);
		System.out.println("xonstructed");
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		 JButton clicked = (JButton) e.getSource();
		 
		 if (clicked == parent.send){
			
			 try{
			 net.send(parent.getText());
			 }
			 catch (IOException e5){
				 System.out.println("Could not send: "+e5);
			 }
			 catch (NullPointerException npe1){
				 System.out.println("Not connected: "+npe1);
			 }
		 }
		 
		 if(clicked == parent.disconnect){
			 net.close();
			 net = null;
			 parent.setConnStatus(" Not Connected");
		 }
		 
		 if (clicked == parent.connect){
			 try {
				net = new Networking(parent.getAddress(),Integer.parseInt(parent.getPort()));
				parent.setConnStatus(" Connected");
			} catch (IOException e1) {
				parent.setConnStatus(" Could not connect");
				// TODO Auto-generated catch block
				System.out.println("O noes! something went wrong connecting to the server!"
						+ "\n IOException"+e1);
			}
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