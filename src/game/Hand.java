package game;

public class Hand {
	//private static Deck deck;
	private int numberAt;
	private int numberOfCards;
	
	public Hand(Deck d) {
		numberOfCards = 0;
		numberAt = 0;
	}

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
	
	public String statusOfHand() {
		if(getNumberAt() == 21 && numberOfCards == 2) {
			return "BLACKJACK!";
		}
		if(getNumberAt() > 21) {
			return "BUST!";
		}
		return Integer.toString(numberAt);
	}
	
	public boolean endOfTurn() {
		if(statusOfHand().equals("BLACKJACK!") || statusOfHand().equals("BUST!")) {
			return true;
		}
		return false;
	}
	public int getNumberOfCards() {
		return numberOfCards;
	}
	public int getNumberAt() {
		return numberAt;
	}
	
}
