package Model;

public class YardSale extends DicePosition{

	public YardSale(int num, String day, String icon) {
		super(num, day, icon);
	}
	public String getIcon() {
		return this.icon;
	}
	public void performAction(Player p,int diceNumber) {
		p.setEuros(p.getEuros()-100*diceNumber);
	}
	public void performAction(Player p,DealCard dc) {
		
	}
}
