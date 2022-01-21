package Model;

public class Card {

	PayDayCards pdc;
	private String[][] mailCards = new String[48][4];
	private String[][] dealCards = new String[20][8];
	public Card(){
		 pdc=new PayDayCards();
		 pdc.readFile("resources/mailCards_greeklish.csv","Mail");
		 this.mailCards=pdc.mailCards;		
		 pdc.readFile("resources/dealCards_greeklish.csv","Deal");
		 this.dealCards=pdc.dealCards;
	}

	public void action() {
		
	}
	public String[][]getMailCards() {
		return this.mailCards;
	}
	public String[][] getDealCards(){
		return this.dealCards;
	}
	
	public int money_of_the_card() {
		return 0;
	}
}
