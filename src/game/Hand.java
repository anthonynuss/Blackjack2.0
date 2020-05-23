package game;

public class Hand {
	//private static Deck deck;
	private static int numberAt;
	
	public Hand(Deck d) {
		//deck = new Deck();
	}

	public Card getRandCard(Deck d) {
		Card temp = d.select();
		numberAt += temp.getRank();
		return temp;
	}
	
	public int getNumberAt() {
		return numberAt;
	}
	
}
