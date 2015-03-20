package com.christian;








import javax.swing.BoxLayout;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//main sprinkler class, includes GUI.


public class Main {

	Main parent;
	
	
	JLabel connStatus;
	JPanel window;
	JPanel connectInfo;
	JTextField custInput,address,port;
	JButton send,connect,disconnect;
	JPanel customMessage,connInfo;
	
	
	
	Main(){
		SprinklerEngine engine = new SprinklerEngine(this);
		
		window = new JPanel();
		connInfo = new JPanel();
		customMessage = new JPanel();
		
		connStatus = new JLabel(" Not Connected");
		
		custInput = new JTextField(30);
		address = new JTextField(10);
		port = new JTextField(5);
		custInput.setText("Command:");
		address.setText("192.168.2.8");
		port.setText("42001");
		
		send = new JButton("Send");
		connect = new JButton("Connect");
		disconnect = new JButton("Disconnect");
		
		send.addActionListener(engine);
		connect.addActionListener(engine);
		disconnect.addActionListener(engine);
		
		BoxLayout box = new BoxLayout(window, 1);
		/*GridLayout gl2 = new GridLayout();
		customMessage.setLayout(gl);
		connInfo.setLayout(gl);*/
		window.setLayout(box);
		
		connInfo.add(address);
		connInfo.add(port);
		connInfo.add(connect);
		connInfo.add(disconnect);
		connInfo.add(connStatus);
		
		customMessage.add(custInput);
		customMessage.add(send);
		
		window.add(connInfo);
		window.add(customMessage);
		
		JFrame frame = new JFrame("Christian's Sprinkler Pi Program!");
		frame.setContentPane(window);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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


}
