import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JOptionPane;


public class Player implements Drawable{

	private int credit = 0; //How much money the player has
	private Ship ship = Ship.shuttle; //The ship the player has
	private String target;  //Sets the current target for the active quest [unimplemented as of now]
	
	public Player(int x, int y)
	{
		this.ship.setX(x);
		this.ship.setY(y);
		
			     
	}
	//Returns the amount of credits the player has.
	public int getCredit() {
		return credit;
	}
	//Determines whether to draw the object or not.
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	//Draws the object
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.drawString("Sector <"/*+sectorX+","sectorY">"*/, 25, 25);
		this.ship.draw(g);
	}
	//Sets the Velocity on the x axis to velocityX
	public void setVelocityX(int velocityX) {
		this.ship.setVelocityX(velocityX);
	}
	//Returns the velocity of the X axis
	public int getVelocityX() {
		return ship.getVelocityX();
	}
	//Sets the velocity on the y axis to velocityY
	public void setVelocityY(int velocityY) {
		this.ship.setVelocityY(velocityY);
	}
	//Returns the velocity on the Y axis
	public int getVelocityY() {
		return this.ship.getVelocityY();
	}
	//Returns the location on the x axis
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.ship.getX();
	}
	//Returns the location on the y axis
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.ship.getY();
	}
	//Sets the location on the x axis
	@Override
	public int setX(int x) {
		// TODO Auto-generated method stub
		return this.ship.setX(x);
	}
	//Sets the location on the y axis
	@Override
	public int setY(int y) {
		// TODO Auto-generated method stub
		return this.ship.setY(y);
	}
	//Gets the speed of the player based on what ship they're using.
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.ship.getSpeed();
	}
	//Changes the direction of the player's flight
	public void setDir(int i) {
		// TODO Auto-generated method stub
		this.ship.setDir(i);
	}
	//Gets the width of the image
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return ship.getWidth();
	}
	//Gets the height of the image
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return ship.getHeight();
	}
	//Performs all of the functions when a collision is detected
	public void doCollide(Drawable d, Window w) {
		// TODO Auto-generated method stub
		
			if(d instanceof SpaceStation){
				SpaceStation s = (SpaceStation)d;
				if(s.hasQuest()){
					new ShopScreen(this, w);
				}
			}	
		
		
	}
	//Changes the amount of credits the player has.
	public void setCredit(int i) {
		// TODO Auto-generated method stub
		this.credit = i;
	}
	//REturns the Ship object of the player
	public Ship getShip() {
		return ship;
	}
	//Sets the Ship object of the player to ship
	public void setShip(Ship ship) {
		this.ship = ship;
	}
}
