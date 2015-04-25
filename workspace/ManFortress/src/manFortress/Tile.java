package manFortress;

import java.awt.Image;
import java.awt.Rectangle;

import java.lang.Math;


import javax.swing.ImageIcon;

//main file for tile loading and behaviours. (lol british spelling)



public class Tile {

		
	
	String grass = "/res/Grassreg.png";
	String dirt = "/res/Dirt.png"; //these are some files we have. Not sure if i should list all images.
	String bush1 = "/res/Bush1.png";
	String stone = "/res/Stone.png";
	String barley = "/res/barley.png";
	String crushedStone = "/res/CrushedStone.png";
	
	String[] blocks = {
			 "/res/air.png",
			 "/res/Grassreg.png",
			 "/res/Dirt.png",
			 "/res/Bush1.png",
			 "/res/Stone.png",
			 "/res/barley.png",
			 "/res/CrushedStone.png",
			 
			 
	};
	
	
	public boolean visible;
	private int x = 0;
	private int y = 0;
	private Image tileImage;
	
	int BLOCK_HEIGHT = 8; // This is just for tiling purposes. We are currently at 8*8 pixels.
	
	
	public Tile(int x, int y, int type, int dat) {
		ImageIcon ii;
		ii = new ImageIcon(getClass().getResource(dirt));
		
		if (type < blocks.length){
			ii = new ImageIcon(getClass().getResource(blocks[type]));
		}
		
		this.x = x*BLOCK_HEIGHT;
		this.y = y*BLOCK_HEIGHT;
		tileImage = ii.getImage();
		
		
		
		// TODO Auto-generated constructor stub
		
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image GetImage(){
		return tileImage;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public Rectangle getBounds(){
		return new Rectangle (x, y, BLOCK_HEIGHT, BLOCK_HEIGHT);
	}

	

}
