package Model;

import javax.swing.JOptionPane;

public class Buyer extends Position{

	public Buyer(int num, String day, String icon) {
		super(num, day, icon);
	}

	public void performAction(Player p,int diceNumber) {
		//na thimithw oti prepei na kanw +1 gia to index
		p.setEuros(p.getEuros()+p.getDeal().get(diceNumber-1).getValue());
		p.getDeal().remove(diceNumber-1);
	}
}
