package Model;

import javax.swing.text.View;

public class Position {

	protected int num;
	protected String day;
	protected String icon;
	public Position(int num, String day,String icon) {
		this.num=num;
		this.day=day;
		this.icon=icon;
	}
	public String getDay() {
		return this.day;
	}
	public void setDay(String day) {
		this.day=day;
	}
	public String getIcon() {
		return this.icon;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int pos) {
		this.num=pos;
	}
	public void performAction(Player p,int diceNumber) {
	
	}
	public void performAction(Player p1,Player p2,int diceNumber) {
		
	}
	public void performAction(Player p,DealCard dc) {
		
	}
	public void performAction(Player p1,Player p2,MailCard mc,int who,Jackpot j) {
		
	}
	
}
