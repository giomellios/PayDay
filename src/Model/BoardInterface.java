package Model;

public interface BoardInterface {

	/**
	 * @param p1
	 * @param p2
	 * @pre Check the player's turn variable
	 * @post Deciding whose turn is right now by some calculations
	 * 
	 * @return 1 or 2
	 */
	public int whose_turn(Player p1,Player p2);
	/**
	 * @param p1
	 * @param p2
	 * 
	 * @post shuffling the Position[] array in order to have a random layout of the 
	 * board, also, initializing the players in here
	 * 
	 */
	
	public void initialize(Player p1,Player p2, Card c);
	/**
	 * @param p1
	 * @param p2
	 * 
	 * @pre Check the win variable of each player which will be checked
	 * in Controller
	 * @post Changing the win variable of the player that won to 1
	 */
	
	public void win(Player p1,Player p2);
	/**
	 * 
	 * @param c
	 * 
	 * 
	 * This method shuffles the deck. I use it only when the deck of cards (either deal or mail cards) are out of cards
	 */
	
	public void shuffle(Card c);
	
	
	/**
	 * Observer
	 * @return The deck of mail cards 
	 */
	
	public MailCard[] getMailCards();
	
	/**
	 * Observer
	 * @return The deck of deal cards 
	 */
	
	public DealCard[] getDealCards();
	
	/**
	 * Observer
	 * @return The position array
	 */
	public Position[] getPosition();
	
}
