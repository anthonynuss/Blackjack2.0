package game;

import java.util.Random;

import game.Card.Suit;

/**
 * Represents a deck of Cards
 * @author tonynuss
 *
 */
public class Deck {
	  /**
	   * The cards comprising this deck.
	   */
	  private Card[] cards;
	  
	  /**
	   * The random number generator to use for selecting cards.
	   */
	  private Random rand;
	  
	  private int numCardsSelected;
	  
	  /**
	   * Constructs a new deck with a default random number generator.
	   */
	  public Deck() {
	    rand = new Random();
	    numCardsSelected = 0;
	    init();
	  }

	  /**
	   * Constructs a new deck with the given random number generator.
	   */
	  public Deck(Random givenGenerator) {
	    rand = givenGenerator;
		init();
	  }
	  
	  /**
	   * Returns a card at random from this deck.
	   */
	  public Card select() {
		//making a new card
		Card hand;
		//gets a random index
		int randIndex = rand.nextInt(52-numCardsSelected);
		hand = cards[randIndex];	//finds the card at that random index and sets it to the deck
		cards[randIndex] = cards[51-numCardsSelected]; //last card in deck goes to that random index
		cards[51-numCardsSelected] = hand; //card at random index goes to end of deck
		numCardsSelected++;
		return hand;
	  }
	  
	  /**
	   * Initializes a new deck of 52 cards.
	   */
	  public void init() {
	    cards = new Card[52];
	    int index = 0;
	    for (int rank = 1; rank <= 13; ++rank)
	    {
	      cards[index] = new Card(rank, Suit.CLUBS);
	      index += 1;
	      cards[index] = new Card(rank, Suit.DIAMONDS);
	      index += 1;
	      cards[index] = new Card(rank, Suit.HEARTS);
	      index += 1;
	      cards[index] = new Card(rank, Suit.SPADES);
	      index += 1;
	    }

	  }
}
