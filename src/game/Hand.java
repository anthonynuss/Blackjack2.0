package game;

public class Hand {
	//private static Deck deck;
	private int numberAt;
	
	public Hand(Deck d) {
		//deck = new Deck();
	}

	public Card getRandCard(Deck d) {
		Card temp = d.select();
		numberAt += temp.getRank();
		return temp;
	}
	
	public String statusOfHand() {
		if(getNumberAt() == 21) {
			return "BLACKJACK!";
		}
		if(getNumberAt() > 21) {
			return "BUST!";
		}
		return Integer.toString(numberAt);
	}
	public int getNumberAt() {
		return numberAt;
	}
	
}
