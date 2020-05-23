package game;

import java.util.Random;

public class Card {
	 /**
	   * Constants for the four suits.
	   */
	  public enum Suit
	  {
	    CLUBS, DIAMONDS, HEARTS, SPADES
	  };

	  /**
	   * Suit for this card.
	   */
	  private final Suit suit;

	  /**
	   * Rank for this card.
	   */
	  private final int rank;
	
	  public Card(int givenRank, Suit givenSuit)
	  {
	    rank = givenRank;
	    suit = givenSuit;
	  }
	  
	  
	  public int getRandRank() {
		  Random rand = new Random();
		  return rand.nextInt(10)+1;
	  }

	  /**
	   * Returns the rank for this card.
	   * 
	   * @return rank for this card
	   */
	  public int getRank()
	  {
	    return rank;
	  }

	  /**
	   * Returns the suit for this card.
	   * 
	   * @return suit for this card
	   */
	  public Suit getSuit()
	  {
	    return suit;
	  }

}
