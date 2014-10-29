import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JInternalFrame;


public class ShopScreen extends JInternalFrame implements ActionListener{

	Label credits;
	Button[] shipBuy = { new Button("Shuttle"), new Button("Cargo"), new Button("Frigate")};
	Player p;
	
	
	public ShopScreen(Player p, Window w){
	this.p=p;
		credits = new Label("Credits: " + p.getCredit());
		this.setLayout(new FlowLayout());
		this.add(credits);
		for(int x = 0; x< shipBuy.length; x++){
			shipBuy[x].addActionListener(this);
			this.add(shipBuy[x]);
		}
		
	    setSize(100,400);
	    
		this.setVisible(true);
		SpaceGame.pauseGame();
	}



	@Override
	public void actionPerformed(ActionEvent s) {
		// TODO Auto-generated method stub
		if(s.getSource() == shipBuy[0]){
			p.setCredit(p.getCredit()-100);
			p.setShip(Ship.shuttle);
		}
		if(s.getSource() == shipBuy[1]){
			p.setCredit(p.getCredit()-150);
			p.setShip(Ship.cargo);
		}
	}
	
	
}
