package game;

import java.util.Random;

import game.Card.Suit;

public class Deck {
	/**
	   * The cards comprising this deck.
	   */
	  private Card[] cards;
	  
	  /**
	   * The random number generator to use for selecting cards.
	   */
	  private Random rand;
	  
	  /**
	   * Constructs a new deck with a default random number generator.
	   */
	  public Deck()
	  {
	    rand = new Random();
	    init();
	  }

	  /**
	   * Constructs a new deck with the given random number generator.
	   */
	  public Deck(Random givenGenerator)
	  {
	    rand = givenGenerator;
		init();
	  }
	  
	  /**
	   * Returns a new array containing k elements selected
	   * at random from this deck.
	   */
	  public Card select()
	  {
		//making a new card
		Card hand;
		
		//loop iterates until there are k elements in the array.
		
			//gets a random index 52-i
			int randIndex = rand.nextInt(52);
			hand = cards[randIndex];	//finds the card at that random index and sets it to the deck
			cards[randIndex] = cards[51]; //last card in deck goes to that random index
			cards[51] = hand; //card at random index goes to end of deck
		
		return hand;
	  }
	  
	  /**
	   * Initializes a new deck of 52 cards.
	   */
	  public void init()
	  {
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
