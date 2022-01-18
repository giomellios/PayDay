package Model;

public class Radio extends DicePosition{

	public Radio(int num, String day, String icon) {
		super(num, day, icon);
	}

	public String getIcon() {
		return this.icon;
	}
	public void performAction(Player p1,Player p2,int diceNumber) {
		if(p1.getDice()>p2.getDice()) {
			p1.setEuros(p1.getEuros()+1000);
		}else if(p1.getDice()<p2.getDice())
			p2.setEuros(p2.getEuros()+1000);
		}
}
