package Model;

public class FamilyCasinoNight extends DicePosition{

	public FamilyCasinoNight(int num, String day, String icon) {
		super(num, day, icon);
	}
	public String getIcon() {
		return this.icon;
	}
	public void performAction(Player p,int diceNumber) {
		if(diceNumber%2==1)
			p.setEuros(p.getEuros()-500);
		else
			p.setEuros(p.getEuros()+500);
	}
}
