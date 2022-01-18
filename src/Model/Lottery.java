package Model;

public class Lottery extends DicePosition{

	public Lottery(int num, String day, String icon) {
		super(num, day, icon);
	}
	public String getIcon() {
		return this.icon;
	}
	
	public void performAction(Player p,int diceNumber) {
		p.setEuros(p.getEuros()+1000);
	}
}
