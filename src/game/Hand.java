package game;

/**
 * Represents a hand in blackjack
 * @author tonynuss
 *
 */
public class Hand {
	/**
	 * The number the hand is at
	 */
	private int numberAt;
	
	/**
	 * The number of cards given in this hand
	 */
	private int numberOfCards;
	
	/**
	 * new hand with default number of cards and number at
	 * @param d a deck
	 */
	public Hand(Deck d) {
		numberOfCards = 0;
		numberAt = 0;
	}

	/**
	 * Gets a random card from the deck and updates the numberAt variable
	 * @param d the deck
	 * @return a card
	 */
	public Card getRandCard(Deck d) {
		Card temp = d.select();
		numberOfCards++;
		//case for face cards
		if(temp.getRank()==11 || temp.getRank()==12 || temp.getRank()==13) {
			numberAt += 10;
		}
		//case for ace
		else if(temp.getRank()==1 && numberAt + 11 <= 21) {
			numberAt += 11;
		}else {
			numberAt += temp.getRank();
		}
		return temp;
	}
	
	/**
	 * The status of the hand. Either blackjack, bust, or the number it is at.
	 * @return the status
	 */
	public String statusOfHand() {
		if(getNumberAt() == 21 && numberOfCards == 2) {
			return "BLACKJACK!";
		}
		if(getNumberAt() > 21) {
			return "BUST!";
		}
		return Integer.toString(numberAt);
	}
	
	/**
	 * Determines if it is the end of the turn
	 * @return true if end of turn
	 */
	public boolean endOfTurn() {
		if(statusOfHand().equals("BLACKJACK!") || statusOfHand().equals("BUST!")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns number of cards
	 * @return number of cards
	 */
	public int getNumberOfCards() {
		return numberOfCards;
	}
	
	/**
	 * Returns number at
	 * @return number at
	 */
	public int getNumberAt() {
		return numberAt;
	}
	
}
