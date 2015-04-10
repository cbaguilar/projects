package com.christian;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

//main sprinkler class, includes GUI.
//test


public class Main {

	Main parent; 
	/*Here is the place where all of the components are declared.
	 * I may remove the declaration for the sprinkler radio buttons/list*/
	//test
	JLabel connStatus,enabled;
	JPanel programSprinklers,directControl;
	JPanel connectInfo,outputPan;
	JPanel sprinklerList,map;
	/*
		JLabel	l1,l2,l3,l4,l5,l6,
			  	l7,l8,l9,l10,l11,l12;
		
		JTextField 	t1,t2,t3,t4,t5,t6,
					t7,t8,t9,t10,t11,t12;
		
		JLabel 	e1,e2,e3,e4,e5,e6,
				e7,e8,e9,e10,e11,e12;
		
		JRadioButton r1,r2,r3,r4,r5,r6,
					 r7,r8,r9,r10,r11,r12;
		
	*/
	JTextField custInput,address,port,time;
	JButton send,connect,disconnect,update;
	JPanel customMessage,connInfo,programbox;
	JComboBox<String[]> programs;
	JCheckBox enabledProgram;
	JTabbedPane tabs;
	JTextPane output;
	
	ArrayList<JLabel> asprinklers;
	ArrayList<JTextField> asprinklerTime;
	ArrayList<JRadioButton> asprinklerEnabled;
	ArrayList<JPanel> asprinklerPanel;
	
	ArrayList<JLabel> conSprinklers;
	ArrayList<JToggleButton> conToggle;

	
	String[] programsList = {"Summer","Winter","number2"};
	String[] sprinkLabels = { 	"One",
								"Two",
								"three",
								"Fower",
								"cinco",
								"seis",
								"seven",
								"octo",
								"nova",
								"decka",
								"once",
								"dozen"};
	
	
	
	Main(){
		tabs = new JTabbedPane();
		

		
		ImageIcon icon = new ImageIcon("src/res/house2.png");
		
		SprinklerEngine engine = new SprinklerEngine(this);
		
		directControl = new JPanel();
		programSprinklers = new JPanel();
		connInfo = new JPanel();
		customMessage = new JPanel();	
		programbox = new JPanel();
		sprinklerList = new JPanel();
		outputPan = new JPanel();
		
		JPanel help = new JPanel();
		help.setLayout(new GridLayout());
		JTextPane para = new JTextPane();
		try {
		para.setContentType("text/html");
		para.setText(readFile("src/com/christian/help.html",Charset.defaultCharset()));
		}
		catch (IOException e){
			System.out.println(e);
		}
		
		
		help.add(para);
		
		tabs.addTab("Program", programSprinklers);
		tabs.addTab("Direct Control",directControl);
		tabs.addTab("Help",help);
		
		output = new JTextPane();
		output.setText("Output");
		
		connStatus = new JLabel(" Not Connected");
		enabled = new JLabel(" Enabled");
		
		programs = new JComboBox(programsList);
		
		enabledProgram = new JCheckBox();
		
		custInput = new JTextField(30);
		address = new JTextField(10);
		time = new JTextField(1);
		port = new JTextField(5);
		custInput.setText("Command:");
		address.setText("192.168.2.8");
		port.setText("42001");
		
		
		send = new JButton("Send");
		connect = new JButton("Connect");
		disconnect = new JButton("Disconnect");
		update = new JButton("UPDATE");
		
		send.addActionListener(engine);
		connect.addActionListener(engine);
		disconnect.addActionListener(engine);
		update.addActionListener(engine);
		
		asprinklers = new ArrayList<JLabel>();
		asprinklerTime = new ArrayList<JTextField>();
		asprinklerEnabled = new ArrayList<JRadioButton>();
		asprinklerPanel = new ArrayList<JPanel>();
		
			for (int i = 0;i < 12;i++){
				GridLayout g = new GridLayout();

				
				asprinklerPanel.add(new JPanel());
				asprinklers.add(new JLabel((i+1)+": "+sprinkLabels[i]));
				asprinklerTime.add(new JTextField(2));
				asprinklerEnabled.add(new JRadioButton());
				
				asprinklerPanel.get(i).setLayout(g);
				
				asprinklerPanel.get(i).add(asprinklers.get(i));
				asprinklerPanel.get(i).add(asprinklerTime.get(i));
				//asprinklerPanel.get(i).add(asprinklerEnabled.get(i));
				
				
				
				
				sprinklerList.add(asprinklerPanel.get(i));
			}
			
			
			
			
		map = new JPanel();
		
		map.setLayout(new GridLayout());
		map.add(sprinklerList);
		map.add(new JLabel(icon));
		
		
		BoxLayout box = new BoxLayout(programSprinklers, 1);
		/*GridLayout gl2 = new GridLayout();
		customMessage.setLayout(gl);
		connInfo.setLayout(gl);*/
		programSprinklers.setLayout(box);
		sprinklerList.setLayout(new BoxLayout(sprinklerList,1));
		
		outputPan.setLayout(new GridLayout());
		
		
		connInfo.add(address);
		connInfo.add(port);
		connInfo.add(connect);
		connInfo.add(disconnect);
		connInfo.add(connStatus);
		
		programbox.add(programs);
		programbox.add(enabled);
		programbox.add(enabledProgram);
		programbox.add(new JLabel(" Time (24 hr format) "));
		programbox.add(time);
		programbox.add(new JLabel(":00  "));
		programbox.add(update);
		
		outputPan.add(output);
		
		customMessage.add(custInput);
		customMessage.add(send);
		
		programSprinklers.add(connInfo);
		programSprinklers.add(programbox);
		programSprinklers.add(map);
		programSprinklers.add(outputPan);
		programSprinklers.add(customMessage);
		
		
		
		
		JFrame frame = new JFrame("Christian's Sprinkler Pi Program!");
		frame.setContentPane(tabs);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
		
	
	public static void main(String[] args) {
		
		
		@SuppressWarnings("unused")
		Main main = new Main();
	
	}
	
	
	public String getText(){
		System.out.println(custInput.getText());
		return custInput.getText();
		
	}
	
	public void setConnStatus(String status){
		connStatus.setText(status);
	}
	
	public String getAddress(){
		return address.getText();
	}
	
	public String getPort(){
		return port.getText();
	}

	public void write(String out){
		output.setText(out);
	}
	
	public void setLabel(int l,String text){
		asprinklers.get(l).setText(text);
	}
	
	public String readFile(String path, Charset encoding) throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	

	    
	

}
