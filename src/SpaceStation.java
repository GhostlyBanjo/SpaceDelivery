import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpaceStation implements Drawable{

	private int x, y;
	private String id;
	private BufferedImage img;
	private boolean hasQuest = false;

	private Quest quest;
	
	public String getId() {
		return id;
	}
	public BufferedImage getImg() {
		return img;
	}
	public boolean hasQuest() {
		return hasQuest;
	}
	public Quest getQuest() {
		return quest;
	}
	public SpaceStation(int x, int y, String id){
		this.x = x;
		this.y = y;
		this.id=id;
		try {
			img = ImageIO.read(new File("Sprites/spacestation.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public SpaceStation(int x, int y, String id, Quest quest){
		this.x = x;
		this.y = y;
		this.id=id;
		try {
			img = ImageIO.read(new File("Sprites/spacestation.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hasQuest =true;
		this.quest = quest;
	} 
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.drawString("Spacestation - " + id, x-10, y);
		g.drawImage(img, x, y, null);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int setX(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setY(int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVelocityX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVelocityY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 512;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 512;
	}
	@Override
	public void setVelocityX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVelocityY(int i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doCollide(Drawable s, Window w) {
		// TODO Auto-generated method stub
		
	}

	
	
}
