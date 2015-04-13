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
		System.out.println("Initialized Sprinkler Engine");
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		 Object acted = e.getSource();
		 
			 
		 
		 if (acted == parent.send){
			
			 try{
			 net.send(parent.getText());
			 }
			 catch (IOException e5){
				 System.out.println("Could not send: "+e5);
				 parent.write("System Output: could not send"+e5);
			 }
			 catch (NullPointerException npe1){
				 System.out.println("Not connected: "+npe1);
				 parent.write("System Output: Not Connected: "+npe1);
			 }
		 }
		 
		 if(acted == parent.disconnect){
			 try{
			 net.close();
			 net = null;
			 System.out.println("Closed Connection");
			 }
			 catch (IOException ioe2){
			 System.out.println("Could not disconnect: "+ioe2);
			 parent.write("Failed to Disconnect: " + ioe2);
			 }
			 catch (NullPointerException npe2){
				 System.out.println("What? You never connected! dummuy! "+npe2);
				 parent.write("System Output: You never connected. "+npe2);
			 }
			 parent.setConnStatus(" Not Connected");
		 }
		 
		 if (acted == parent.connect){
			 try {
				net = new Networking(parent.getAddress(),Integer.parseInt(parent.getPort()));
				parent.setConnStatus(" Connected");
			} catch (IOException e1) {
				parent.setConnStatus(" Could not connect");
				// TODO Auto-generated catch block
				System.out.println("O noes! something went wrong connecting to the server!"
						+ "\n IOException"+e1);
				parent.write("System Output: Could not connect "+ e1);
			}
		
		
		 }
		 
		 if (acted == parent.update){
				System.out.println("Printing days");
				Boolean[] days = parent.getDays();
				for (int i = 0; i< 7; i++){
					System.out.println(days[i]);
				}
				int[] times = parent.getTimes();
				for (int i = 0; i<12; i++){
				System.out.println(times[i]);
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
