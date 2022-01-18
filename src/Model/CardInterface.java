package Model;

public interface CardInterface {

	/**
	 * Each card has a specific action, so it must be implemented by this action() method
	 */
	public void action();
	/**
	 * @pre (Almost) Every card has an amount of money on it that needs to be
	 * handled, so we check this amount of money
	 * @post If the card contains money, we return the amount that is contained, otherwise we return 0;
	 * @return amount of money
	 */
	public int money_of_the_card();
}
