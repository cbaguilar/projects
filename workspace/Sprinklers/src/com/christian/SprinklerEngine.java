package com.christian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
			 
			 if (net == null){ 
			 try {
				net = new Networking(parent.getAddress(),Integer.parseInt(parent.getPort()));
				parent.setConnStatus(" Connected");
				
				String str = net.receive();
				parent.setProgram(str);
				System.out.println(str);
				
			} catch (IOException e1) {
				parent.setConnStatus(" Could not connect");
				
				System.out.println("O noes! something went wrong connecting to the server!"
						+ "\n IOException"+e1);
				parent.write("System Output: Could not connect "+ e1);
			}  catch (ParseException pe1){
				System.out.println("There was an error in the recieved program...");
				parent.write("Error in recived program");
			
			}
			 }
			 
		 }
		
		
		 
		 
		 if (acted == parent.update){
				System.out.println("Printing days");
				JSONArray days = parent.getDays();
				for (int i = 0; i< 7; i++){
					System.out.println(days.get(i));
				}
				JSONArray times = parent.getTimes();
				
				JSONObject command = new JSONObject();
				JSONObject program = new JSONObject();
				
				JSONObject timeobj = new JSONObject();
				JSONObject daysobj = new JSONObject();
				
				
				program.put("times", times);
				program.put("days", days);
				program.put("start", parent.getStartTime());
				
				command.put("type", "program");
				
				command.put("program", program);
				
				//
				for (int i = 0; i<12;i++){
					if (Integer.parseInt(((String)parent.getTimes().get(i)))>15){
						parent.write("WARNING: TIME IS SET LONG! TIME IS OVER 15 MINUTES!!");
					}
				}
				
				
				System.out.println(command.toString());
				
				String cmdstr = command.toString();
				try{
					net.send(cmdstr);
					System.out.println(cmdstr);
				}
				catch (IOException ioe){
					parent.write("Error Sending: "+ioe);
					
				}
				catch (NullPointerException npe1){
					 System.out.println("Not connected: "+npe1);
					 parent.write("System Output: Not Connected: "+npe1);
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
