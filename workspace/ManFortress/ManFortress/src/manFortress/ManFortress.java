package manFortress;


import javax.swing.JFrame;

import java.awt.EventQueue;
import java.io.File;
import java.io.InputStream;

import javax.sound.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;








import java.lang.Class;
import java.util.Scanner;


public class ManFortress extends JFrame{

	public ManFortress()
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to [l]oad an existing level or open the [h]ardcoded cheap pile of blocks.");
		System.out.println("You can also [c]onvert a level (copy/paste) by entering. \n");
		String ans = in.next();
		String file = "poo";
		
		if (ans == "l"){
			System.out.println("Please enter a full file name. \n");
			file = in.next();
		}
		
		if (ans == "c"){
			System.out.println("Now enter the text of your stuff");
			file = in.next();
			FileIO save = new FileIO();
			
			
		}
		
		if (ans == "h"){
			System.out.println("Now starting Ages of Men with some hardcoded pile");
			
		}
		
		
		
		
		add(new Board(file));
		
		setSize(960, 720); 
		setResizable(true);
		setTitle("Man Fortress");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	

	
	
	
	
	// TODO Auto-generated method stub

}
	
	public static void main(String[] args) {
		

	
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			
			
			
			public void run() {
		
				new ManFortress();
			
			}
		});
		// TODO Auto-generated method stub

	


}
}
