package boxstudios;

import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;



	public class Main extends JFrame{

		
		public Main()
		{
			
			add(new Board());
			
			setSize(960, 720); 
			setResizable(true);
			setTitle("Beatdown Alpha Build");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setVisible(true);
			
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {EventQueue.invokeLater(new Runnable() {
		@Override
		
		
		
		public void run() {
	
			new Main();
		
		}
	});
		// TODO Auto-generated method stub
		
	}

}
