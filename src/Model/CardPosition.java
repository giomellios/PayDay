package Model;

public class CardPosition extends Position{

	public CardPosition(int num, String day,String icon) {
		super(num, day,icon);
	}
	public Card getCards(Card c) {
		return null;
	}
	public String getIcon() {
		return this.icon;
	}
}
