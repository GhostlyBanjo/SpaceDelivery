import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Ship implements Drawable{

	private BufferedImage[] img = new BufferedImage[4];
	public static Ship shuttle = new Ship(5, 10,10, "Sprites/shuttle");
	public static Ship cargo = new Ship(10, 15, 15, "Sprites/cargo");
 int maxcargo, speed, armor, cargohold;
	private int dir;
	private int velocityX, velocityY;
	private int locX, locY, sX, sY;
	
	
	public Ship(int maxcargo, int speed, int armor, String imageLoc){
	this.maxcargo = maxcargo;
	this.speed = speed;
	this.armor = armor;
	this.dir=0;
	try {
		img[0] = ImageIO.read(new File(imageLoc + "_1.png"));
		img[1] = ImageIO.read(new File(imageLoc + "_2.png"));
		img[2] = ImageIO.read(new File(imageLoc + "_3.png"));
		img[3] = ImageIO.read(new File(imageLoc + "_4.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		 g.drawImage(this.img[dir], locX, locY, 48, 48, null);
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
		if(velocityX < 0){
			this.dir = 3;
		}
		if(velocityX > 0){
			this.dir = 1;
		}
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
		if(velocityY < 0){
			this.dir = 0;
		}
		if(velocityY < 0 ){
			this.dir = 2;
		}
	}

	public int getVelocityY() {
		return velocityY;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.locX;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.locY;
	}

	@Override
	public int setX(int x) {
		// TODO Auto-generated method stub
		this.locX=x;
		return this.locX;
	}
	@Override
	public int setY(int y) {
		// TODO Auto-generated method stub
		this.locY=y;
		return this.locY;
	}
	public int getMaxcargo() {
		return maxcargo;
	}
	public void setMaxcargo(int maxcargo) {
		this.maxcargo = maxcargo;
	}
	public int getSpeed() {
		return speed;
	}
	public int getArmor() {
		return armor;
	}
	public void setDir(int i) {
		// TODO Auto-generated method stub
		this.dir=i;
	}
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return img[0].getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return img[0].getHeight();
	}
	public void doCollide(Drawable s, Window w) {
		// TODO Auto-generated method stub
	
		
		
	}
	public int getCargo() {
		return cargohold;
	}
	public void setCargo(int cargo) {
		this.cargohold = cargohold;
	}
	}
