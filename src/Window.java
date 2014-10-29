import static java.lang.System.out;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/*This is a game about the less appreciated side of space flight.  Normally, a space game like this would be a shoot 'em up style game and you'd be flooded with an onslaught of enemies in an attempt to survive.
 * 
 * The point of this game isn't to be the baddest baddie in the video game world, but the best cargo transporter.  The player flies between space stations delivering cargo.  
 * 
 * The player will [soon] be able to upgrade their ship to fly faster, hold more cargo, and have tougher armor to withstand hits from [as of now unimplemented] asteroids and random space debris.
 * 
 */


public class Window extends Frame   implements KeyListener
{
        //declare variables global

// direction constants
private final static int SCHEIGHT=768,SCWIDTH=1024; //Constants for the screen width and height 
final static int N = 0,NE = 1,E = 2,SE = 3, S = 4, SW = 5, W = 6, NW =7,STILL = 8;
// movement change constants
final  int X = 0,Y = 1,Z = 2;
final int TITLE = 30, STATUS = 40;
final static int size = 2;
   //instance variables
//Background Image
BufferedImage background;
//Player variable
Player player; 
//Delay value
int delay = 30; 
//Checks whether the game is over or not
boolean gameNotOver = true; 
//Is the game paused?
static boolean paused = false; 
//DevMode variable.
boolean devMode = true;
//The coordinates of the active Sector that the player is currently in.
int activeX=0,activeY=0; 
// This giant array is the map.  It houses all of the Sector info.  It's so that the program can access the different sectors easily.
Sector[][] sector = {{new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 {new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector(),new Sector()},
    					 };
//An arrayList that contains all the entities in the active sector
ArrayList<Drawable> things; 
private Image myScreen;
public Window()
{       
	try {
		background = ImageIO.read(new File("background.png"));  //Reads the background image form the file
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
    setSize(SCWIDTH,SCHEIGHT);
    addWindowListener(new WindowAdapter()
          {
              public void windowClosing(WindowEvent e)
                {
                  System.exit(0);
                }
           });


       
    
   setLayout(new FlowLayout(FlowLayout.LEFT));
 
   this.addKeyListener(this);
   player = new Player(100,100);//Adds a player to the game.
   sector[activeX][activeY] = new Sector(player);//Sets the sector at activeX,activeY as the player's starting sector
   sector[1][2] = new Sector(new SpaceStation(200,200,"2B", new Quest("2B","7C",5)));//Changes the sector at 1,2 to contain a SpaceStation that gives out a quest.
   sector[6][3] = new Sector(new SpaceStation(200,300,"7C")); //Adds a generic SpaceStation at sector 6,3
   things = sector[activeX][activeY].getThings(); //gets the array of drawable objects from the sector
   this.setVisible(true);
   do       // game loop

     {
	 if(!SpaceGame.isPaused()){ //If the game is not paused, the game's calculations will run
	   this.checkCollisions();
        this.repaint();
        System.out.println(activeX+","+activeY);
        pause(30);}else{
        	
        }
	 
     }
   while (gameNotOver);     
}// end of mainInput
//Puts the player into the active sector and gets the list of objects to draw from the active sector.
private void setActiveSector() 
{
	// TODO Auto-generated method stub
	sector[activeX][activeY].setP(player);	
	things = sector[activeX][activeY].getThings();
}
//Draws the window
public void paint(Graphics pen)  
 {    
        myScreen =createImage(getSize().width,getSize().height);
        Graphics o = myScreen.getGraphics();
        doubleBuffer(o);
        pen.drawImage(myScreen,0,0,null);
     
        	pen.setColor(Color.cyan);
        	pen.drawString(activeX + "," +activeY, 10,10);
        
  }   
//Draws the window
public void doubleBuffer(Graphics pen)
{   

	

	//  pen.setColor(Color.black);                   
 //    pen.fillRect(0,0,SCWIDTH,SCHEIGHT);
     //pen.setColor(Color.darkGray);
 	pen.drawImage(background, 0, 0, this.getWidth(),this.getHeight(), null);
     //player.draw(pen);
 	for(Drawable i: things){
		i.draw(pen);
	}
    
   
  }    
//Gets the user input to move the player about in the game.
public void keyPressed(KeyEvent e)
{
	
    setTitle(""+ KeyEvent.getKeyText(e.getKeyCode()));  
    System.out.println("hit + "+ KeyEvent.getKeyText(e.getKeyCode()));
    switch(e.getKeyCode())
       {
       	  case KeyEvent.VK_DOWN :player.setVelocityY( player.getSpeed());
       	  						 player.setVelocityX(0);
       	  						 player.setDir(2);
       	                        break; //Sets the player's movement
       	  case KeyEvent.VK_UP :player.setVelocityY( -1* player.getSpeed());
       	  					   player.setVelocityX(0);
       	  					   player.setDir(0);
       	                        break; //Sets the player's movement
       	  case KeyEvent.VK_RIGHT :player.setVelocityX( player.getSpeed());
       	  						  player.setVelocityY(0);
       	  						  player.setDir(1);
       	                        break;  //Sets the player's movement
       	  case KeyEvent.VK_LEFT :player.setVelocityX( -1*player.getSpeed());
       	  						 player.setVelocityY(0);
       	  						 player.setDir(3);
       	                        break;  //Sets the player's movement
       	  case KeyEvent.VK_END :
							     player.setVelocityY(0);
							     player.setVelocityX(0);
       	                          break; //Stops the player completly
       	                          case KeyEvent.VK_ESCAPE :gameNotOver = false;
       	                        break;
      	  
       }

}

public void keyReleased(KeyEvent e) //Unused
{
}
public void keyTyped(KeyEvent e)//Unused
{
}
public void update(Graphics G) //Unused
{
	  paint(G);
}	    
//Checks for collisions between all of the game objects.
public void checkCollisions() 
{
	
	for(Drawable s:things){
		if(s!=player){
			doesCollide(player, s, this);
		}

		upDateLocations(s);
}
}


public void doesCollide(Drawable i, Drawable s, Window w) //Checks if two objects collide.  If they do, it runs the doCollide() method in the Drawable i
{

if(i.getX() < s.getX()+s.getWidth()){
	if(i.getX()+i.getWidth() > s.getX() )
		if(i.getY() < s.getY()+s.getHeight())
			if(i.getY()+i.getHeight() > s.getY() )				
				{	
					i.doCollide(s, w);
					i.setVelocityX(i.getVelocityX()*-1);
					i.setVelocityY(i.getVelocityY()*-1);
				}
				
}


}
public void upDateLocations(Drawable i) //Updates the locations of moving objects in the game and moves things to different sectors when needed.
{
	
   i.setX(i.getX() + i.getVelocityX());	
   i.setY(i.getY() + i.getVelocityY());
   if(i.getX() <= 0){
	   
	   if(activeX !=0)
	   {
		   activeX--;
		   setActiveSector();
		   i.setX(this.getWidth());
	   }else{activeX=sector.length-1;}
	   
	   
   }
   if(i.getX() >this.getWidth()){
	   
	   if(activeX !=sector.length-1)
	   {
		   activeX++;
		   setActiveSector();
		   i.setX(1);   
	   }else{activeX=0;}
	   
   }
   if(i.getY() <= 0){
	  
	   if(activeY !=0)
	   {
		 activeY--;
		 setActiveSector();
		 i.setY(this.getHeight()); 
	   }else{
		activeY=sector[0].length-0;   
	   }
	   
   }
   if(i.getY() >this.getHeight()){
	   
	   if(activeY !=sector[0].length-1)
	   {
		   activeY++;
		   setActiveSector();
		   i.setY(1);
	   }else{
		activeY=0;   
	   }
	   
   
   }
   }

public static void pause (long r)
{
    try
       {
       	   Thread.sleep(r);
       }
    catch (Exception e) 
       {
       	   out.println(" sleep error " + e);
    	}   	   
}
}

