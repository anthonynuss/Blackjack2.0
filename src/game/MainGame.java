package game;

public class MainGame {
	public static void main(String args[]) {
		System.out.println("Starting game...");
		Display display = new Display();
		boolean play = true;
					
		while(play)	{		
			//deal cards
			Deck deck = new Deck();

			Hand playerHand = new Hand(deck);
			Hand dealerHand = new Hand(deck);
			
			playerHand.getRandCard(deck);
			dealerHand.getRandCard(deck);
			playerHand.getRandCard(deck);
			dealerHand.getRandCard(deck);
			
			//hit
			playerHand.getRandCard(deck);
			if(playerHand.getNumberAt() > 21) {
				play = false;
			}
		}
		
	}
}
