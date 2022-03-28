package Model;


public class Sweepstakes extends DicePosition{

	public Sweepstakes(int num, String day, String icon) {
		super(num, day, icon);

	}
	public String getIcon() {
		return this.icon;
	}
	public void performAction(Player p,int diceNumber) {
		p.setEuros(p.getEuros()+diceNumber*1000);
	}
}
