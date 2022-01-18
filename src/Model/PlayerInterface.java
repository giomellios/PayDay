package Model;

public interface PlayerInterface {

	/**
	 * @param euros
	 * Accessor
	 * @post Changes the amount of money of the player to the parameter euros
	 */
	public void setEuros(int euros) ;
	/**
	 * Observer
	 * @return The amount of money of the player
	 */
	public int getEuros() ;
	/**
	 * Observer
	 * @return The amount of money that the player has loaned
	 */
	public int getLoan() ;
	/**
	 * Accessor
	 * @post Changes the amount of loan money to the parameter loan
	 * @param loan
	 */
	public void setLoan(int loan) ;
	/**
	 * Observer 
	 * @return The amount of DealCards the player has
	 */
	public int getDealCards() ;
	/**
	 * Accessor
	 * @param deal
	 * @post Change the number of dealCards to the parameter deal
	 */
	public void setDealCards(int deal) ;
}
