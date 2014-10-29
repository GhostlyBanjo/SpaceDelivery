import java.awt.Graphics;



public interface Drawable {
public void draw(Graphics g);
public boolean isVisible();
public int getX();
public int getY();
public int setX(int x);
public int setY(int y);
public int getVelocityX();
public int getVelocityY();
public int getWidth();
public int getHeight();
public void doCollide(Drawable s, Window w);
public void setVelocityX(int i);
public void setVelocityY(int i);

}
