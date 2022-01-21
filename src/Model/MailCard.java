package Model;

public class MailCard extends Card {


	private int money;
	private String icon,message,choice;
	public MailCard(int money,String icon,String message,String choice) {
		this.money=money;
		this.icon=icon;
		this.message=message;
		this.choice=choice;
	}
	public int getMoney() {
		return this.money;
	}
	public String getIcon() {
		return this.icon;
	}
	public String getMessage() {
		return this.message;
	}
	public String getChoice(){
		return this.choice;
	}
	public void action(Player p1,Player p2,MailCard mc,int who) {
		
	}
	public void action(Player p,MailCard mc,Jackpot j) {
		
	}
	
}
