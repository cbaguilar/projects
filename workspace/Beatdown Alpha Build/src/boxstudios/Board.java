package boxstudios;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent butts) {
		// TODO Auto-generated method stub
		repaint();
		
		
}
	
// 	

public Board(){
	
	
	BackgroundWhatever = new ImageIcon(getClass().getResource("/res/img.sweetpotato.jpg"));
	}
	
	ImageIcon BackgroundWhatever;
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(BackgroundWhatever.getImage(), 0, 0, this);

		Toolkit.getDefaultToolkit().sync();
	    g.dispose();
	}
	
	
}
