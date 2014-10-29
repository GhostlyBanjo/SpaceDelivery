/*


(C) Davis Games Research


Space Delievery Version Pre-Alpha 0.0.0.1 by Forrest Davis III


Changelog :
* Added changelog.
* Added version number
* Fixed a bug where the player doesn't fly to different sectors.

*/
	
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;					

import java.util.*;								

import static java.lang.System.*;
import static java.lang.Math.*;

import java.awt.*;								
import java.awt.event.*;								
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.*;   //for files						
public class SpaceGame {

public String version = "pre-alpha 0.0.0.01";
public String changelog = "Added version number.\nAdded ";

private final static int SCHEIGHT=768,SCWIDTH=1024;
private static boolean pause = false; //This is the variable that is read byt he game to decide whether or not to do any of the calculations during the gameLoop.


public static void pauseGame()  //Sets the pause variable to true
{
	pause = true;
}
public static void unpauseGame()  //Sets the pause variable to false
{
	pause = false;
}
public static boolean isPaused(){return pause;} //Returns the value of the pause variable to indicate whether or not the game is pausd

	public static void main(String args[])
	{
        new Window();  //Make a window
    }
}
