package Model;

public class CardPosition extends Position{

	public CardPosition(int num, String day,String icon) {
		super(num, day,icon);
	}
	//tha kaleitai kathe fora pou tha peftw se cardposition kai tha epistrefei mia tixaia karta apo ta arrays
	public Card getCards(Card c) {
		return null;
	}
	public Card kind_of_card() {
		return null;
	}
	public String getIcon() {
		return this.icon;
	}
	//	tha elegxw analoga to icon an einai dealcard, mailcard, mailcard(2)
}
