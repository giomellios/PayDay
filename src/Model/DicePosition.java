package Model;

public class DicePosition extends Position{

	private int money;
	private int diceNumber;
	
	public DicePosition(int num, String day,String icon) {
		super(num, day, icon);
	}
	public void setDiceNumber(int dice) {
		this.diceNumber=dice;
	}
	
	public void performAction(Player p,int diceNumber) {
		
	}
	
}
