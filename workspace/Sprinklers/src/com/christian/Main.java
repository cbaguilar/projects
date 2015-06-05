package com.christian;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*main sprinkler class, includes GUI.
* test
* 
*/

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
	
	/* Changeable objects, sprinkler label, time, enabled,
	 *  and group panel, respectively
	 */
	
	ArrayList<JLabel> asprinklers;
	ArrayList<JTextField> asprinklerTime;
	//ArrayList<JRadioButton> asprinklerEnabled; Instead of enabling, 0 will just be disabled
	ArrayList<JPanel> asprinklerPanel;
	
	
	// these arent used, not sure why they are here
	//ArrayList<JLabel> conSprinklers;
	//ArrayList<JToggleButton> conToggle;
	
	/* List of the checkboxes for date/time and their panel
	 * 
	 */
	ArrayList<JCheckBox> daycheck;
	ArrayList<JPanel> daypanels; 
	//list of programs, not functional now
	String[] programsList = {"Summer","Winter","number2"};
	
	//List of sprinkler names, can be changed like "garden" etc.
	String[] sprinkLabels = { 	"One",
								"Two",
								"Three",
								"Four",
								"Five",
								"Six",
								"Seven",
								"Eight",
								"Nine",
								"Ten",
								"Eleven",
								"Twelve"};
	
	//String for days name, (for translating in spanish? lol)
	
	String[] days = {"Monday",
					"Tuesday",
					"Wednesday",
					"Thursday",
					"Friday",
					"Saturday",
					"Sunday"
	};
	
	
	/*Basically everything that is in the main class...
	 * 
	 */
	
	
	
	Main(){
		
		//set the tabs
		tabs = new JTabbedPane();
		

		//image of the house
		ImageIcon icon = new ImageIcon("src/res/house2.png");
		
		//engine
		final SprinklerEngine engine = new SprinklerEngine(this);
		
		//initialize main top level panels
		
		directControl = new JPanel();
		programSprinklers = new JPanel();
		connInfo = new JPanel();
		customMessage = new JPanel();	
		programbox = new JPanel();
		sprinklerList = new JPanel();
		outputPan = new JPanel();
		
		/*
		 * This is info about the help page, currently stored in help.html
		 */
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
		
		//adding the little tabs..
		
		tabs.addTab("Program", programSprinklers);
		tabs.addTab("Direct Control",directControl);
		tabs.addTab("Help",help);
		
		
		//start setting values of text panes
		output = new JTextPane();
		output.setText("Output");
		
		connStatus = new JLabel(" Not Connected");
		enabled = new JLabel(" Enabled");
		
		programs = new JComboBox(programsList);
		programs.addActionListener(engine);
		
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
		//asprinklerEnabled = new ArrayList<JRadioButton>();
		asprinklerPanel = new ArrayList<JPanel>();
		
		
		
			for (int i = 0;i < 12;i++){
				GridLayout g = new GridLayout();

				
				asprinklerPanel.add(new JPanel());
				asprinklers.add(new JLabel((i+1)+": "+sprinkLabels[i]));
				asprinklerTime.add(new JTextField(2));
				//asprinklerEnabled.add(new JRadioButton()); not using this as mentioned before
				
				asprinklerPanel.get(i).setLayout(g);
				
				asprinklerPanel.get(i).add(asprinklers.get(i));
				asprinklerPanel.get(i).add(asprinklerTime.get(i));
				//asprinklerPanel.get(i).add(asprinklerEnabled.get(i));
				
				
				
				
				sprinklerList.add(asprinklerPanel.get(i));
			}
			
		JPanel daypanel = new JPanel();
		daypanel.setLayout(new BoxLayout(daypanel, 1));
		daycheck = new ArrayList<JCheckBox>();
		daypanels = new ArrayList<JPanel>();	
		
		for (int i = 0; i < 7; i++){
			GridLayout g = new GridLayout();
			daycheck.add(new JCheckBox());
			daypanels.add(new JPanel());
			
			
			JPanel current = daypanels.get(i);
			current.add(new JLabel(days[i]));
			current.add(daycheck.get(i));
			current.setLayout(g);
			daypanel.add(current);
		}
		
		
			
		map = new JPanel();
		
		//map.setLayout();
		map.add(daypanel);
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
		
		//programbox.add(programs);
		//programbox.add(enabled);
		//programbox.add(enabledProgram);
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
		
		//I remember being dropped off at abuelitas. I cried because mama left me.
		//I was on the bed of Tia Emma or Lupe, probably emma
		//I cried until i fell asleep, and Abuelita made my a rolled up tortilla with nothing but
		/* saltand lemon in it
		 * I wandered around the big house, with its fruit trees, and loquats (i thought they were cumquats)
		 * i had lots of oranges and little green lemons
		 * 
		 *There were pinecones and lots of plants. There was a chicken coop in the corner. I sometimes
		 *helped gather eggs. Chickens would fly from side to side sometimes
		 *I hung out with Emily, who had a pool and cable tv so we could watch spongebob
		 *
		 *Benjamin was my buddy cousin. I always called his name in his spanish pronounciation
		 *We would ride scooters around his house and throw mud. We would
		 *ride the little black truck until it broke
		 *
		 *
		 *
		 *
		 *
		 *
		 */
		
		
		JFrame frame = new JFrame("Christian's Sprinkler Pi Program!");
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					
					engine.net.close();
					System.out.println("closing sock");
				}
				catch (NullPointerException npe2)  {
					System.out.println("Could not close socket");
					write("unable to close!! were dooomed!");
				}
				catch (IOException p){
					write("Something happened");
					System.out.println("socket closing phailde");
				}
				
			}
		});
		
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
	
	public String getStartTime(){
		return time.getText();
	}

	public void write(String out){
		output.setText(out);
	}
	
	public void setLabel(int l,String text){
		asprinklers.get(l).setText(text);
	}
	
	
	
	public void setProgram(String program) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject Oprogram = (JSONObject)parser.parse(program);
		JSONArray times = (JSONArray)Oprogram.get("times");
		JSONArray days = (JSONArray)Oprogram.get("days");
		for (int i = 0; i<12; i++){
			asprinklerTime.get(i).setText((String)times.get(i));
		}
		
		for (int i = 0; i<7; i++){
			daycheck.get(i).setSelected((Boolean)days.get(i));
		}
		time.setText((String)Oprogram.get("start"));
	}
	
	public String readFile(String path, Charset encoding) throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	public JSONArray getDays(){
		/*Boolean[] bool = {
				daycheck.get(0).isSelected(),
				daycheck.get(1).isSelected(),
				daycheck.get(2).isSelected(),
				daycheck.get(3).isSelected(),
				daycheck.get(4).isSelected(),
				daycheck.get(5).isSelected(),
				daycheck.get(6).isSelected(),
			
							};*/
		JSONArray daysj = new JSONArray();
		for (int i = 0; i < 7; i++){
			daysj.add(daycheck.get(i).isSelected());
		}
		
		return daysj;
		
	}
	
	public JSONArray getTimes(){
		/*Hint[] times = {
				Integer.parseInt(asprinklerTime.get(0).getText()),
				Integer.parseInt(asprinklerTime.get(1).getText()),
				Integer.parseInt(asprinklerTime.get(2).getText()),
				Integer.parseInt(asprinklerTime.get(3).getText()),
				Integer.parseInt(asprinklerTime.get(4).getText()),
				Integer.parseInt(asprinklerTime.get(5).getText()),
				Integer.parseInt(asprinklerTime.get(6).getText()),
				Integer.parseInt(asprinklerTime.get(7).getText()),
				Integer.parseInt(asprinklerTime.get(8).getText()),
				Integer.parseInt(asprinklerTime.get(9).getText()),
				Integer.parseInt(asprinklerTime.get(10).getText()),
				Integer.parseInt(asprinklerTime.get(11).getText()),
				
		};*/
		
		JSONArray timesj = new JSONArray();
		for (int i=0;i < 12; i++){
			String t = asprinklerTime.get(i).getText();
			if (t.equals("")){
				timesj.add("0");
			}
			else{
				timesj.add(t);
			}
		//	System.out.println(asprinklerTime.get(i).getText());
			//System.out.println(timesj.get(i).toString());
		}
		//System.out.println("Current Times "+timesj.toString());
		return timesj;
	}



	
	
	    
	

}
