package manFortress;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.ArrayList;









import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;









public class Board extends JPanel implements ActionListener{
	
	
	Timer timer;
	Image ground;
	String groundFile = ("/res/mtnbground1.png");
	Level level;
	
	
	public Board(String args){
		//addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		
		FileIO fio = new FileIO();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		level = new Level();
		
		
		
		
		
		
		timer = new Timer(5,this);
		timer.start();
		
		
		
		level.buildLevel(level.getTestLevel());
		int[] a = level.getTestLevel();
		System.out.println(a[level.getTile(8,13,level.getTestLevel())]);
		
	}
	
	private void getGround(){
		ImageIcon groundii = new ImageIcon(getClass().getResource(groundFile));
		ground = groundii.getImage();
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(ground, 0, 0, this);
		
		
		ArrayList lis = level.getTiles();
		//System.out.println(lis.size());
		for (int i = 0; i <lis.size(); i++){
			Tile t = (Tile) lis.get(i);
			g2d.drawImage(t.GetImage(), t.getX(), t.getY(), this);
		}
		
		Tile tt = new Tile(5,5,1,0);
		g2d.drawImage(tt.GetImage(), tt.getX(), tt.getY(), this);
		
		
		

	    Toolkit.getDefaultToolkit().sync();
	    g.dispose();
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		ArrayList lis = level.getTiles();
		// TODO Auto-generated method stub
		for (int i = 0; i < lis.size(); i++){
			Tile t = (Tile) lis.get(i);
			Rectangle r1 = t.getBounds();
			
			
			if (t.isVisible()){
				
			}
			else
			{

				//lis.remove(i);
			}
			
		}
			
			
		repaint();
		getGround();
		
	}

	
}
