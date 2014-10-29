import java.awt.Graphics;
import java.util.ArrayList;


public class Sector{

	private ArrayList<Drawable> things = new ArrayList<Drawable>();
	private Player p;

	public Sector(){
		
	}
	public Sector(Player p){
		this.setP(p);
		things.add(p);
	}
	public Sector(SpaceStation s)
	{
		
		things.add(s);
	}
	
	

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for(Drawable i: things){
			i.draw(g);
		}
	}

	public ArrayList<Drawable> getThings(){
		return this.things;
	}
	public void setP(Player p) {
		this.p = p;
		things.add(p);
	}
	public Player getP() {
		return p;
	}
	
		
}
