package Model;

public class Card {

	PayDayCards pdc;
	protected String[][] mailCards = new String[48][4];
	protected String[][] dealCards = new String[20][8];

	public Card(){
		 pdc=new PayDayCards();
		 pdc.readFile("resources/dealCards_greeklish.csv","Deal");
		 pdc.readFile("resources/mailCards_greeklish.csv","Mail");
		 this.mailCards=pdc.mailCards;
		 this.dealCards=pdc.dealCards;
	}

	public void action() {
		
	}
	
	public int money_of_the_card() {
		return 0;
	}


	
}
