package Model;

import View.View;

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
	
	/**
	 * This method is for the SundayFootballDay, if the day is sunday, the player can bet on the result of the match depending on the number the diceNumber got
	 * 
	 * @param diceNumber
	 * @param p
	 * @param v
	 * @param who
	 */
	public void SundayFootballDay(int diceNumber, Player p, View v, int who);
	/**
	 * This method is for the Crypto day, if the day is thursday, the player can bet on the cryptocurrency which depends on the number of diceNumber
	 * @param diceNumber
	 * @param p
	 * @param v
	 * @param who
	 */
	public void Crypto(int diceNumber, Player p, View v, int who);
	
	/**
	 * This method checks the money and if this number is negative, it automatically gives the Player p loaning money.
	 * @param money
	 * @param p
	 */
	public void checkLoan(int money,Player p) ;
}
