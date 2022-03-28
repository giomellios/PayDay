package Model;

public interface CardInterface {

	/**
	 * Each card has a specific action, so it must be implemented by this action() method
	 */
	public void action();
	
	/**
	 * Observer
	 * @return The array of mail cards from the given code
	 */
	public String[][]getMailCards();
	
	
	/**
	 * Observer
	 * @return The array of deal cards from the given code
	 */
	public String[][] getDealCards();
}
