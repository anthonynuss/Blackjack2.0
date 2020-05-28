package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * represents the display of the game
 * @author tonynuss
 *
 */
public class Display implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private Deck deck;
	private Hand playerHand;
	private Hand dealerHand;
	private JButton dealerCard2;
	private JButton deal;
	private JButton hit;
	private JButton doubleDown;
	private JButton stand;
	private JButton newGame;
	
	//betting buttons/labels
	private JLabel totalMoney;
	private JLabel currBet;
	private JLabel betAmount;
	private JButton fiveBet;
	private JButton tenBet;
	private JButton twentyFiveBet;
	
	private Chips chips;
	private int cardLocation;
	private int dealerCardLocation;
	
	private JLabel numAt;
	private JLabel dealerNumAt;
	private JLabel background;
	private Card dCard2;

	/**
	 * Constructs a new display
	 * @param d a deck
	 * @param f a frame
	 */
	public Display(Deck d, JFrame f, Chips c) {
		this.deck = d;
		this.chips = c;
		
		frame = f;
        background = null;
        
		try {
			background = new JLabel(new ImageIcon(ImageIO.read(new File("..//BlackJack2.0//resources//table.jpeg"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setContentPane(background);
        panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
       
        frame.setVisible(true);
        panel.setLayout(null);
        
        //adds bet amount option
        totalMoney = new JLabel("Balance: " +chips.getAmountOfChips());
        totalMoney.setBounds(300, 500, 150, 20);
        background.add(totalMoney);
        
        currBet = new JLabel("Bet Amount: " +chips.getCurrentBet());
        currBet.setBounds(300, 520, 150, 20);
        background.add(currBet);
 
        betAmount = new JLabel("Place your bet:");
        betAmount.setBounds(300, 560, 150, 20);
        background.add(betAmount);
        
        fiveBet = new JButton(new ImageIcon("..//BlackJack2.0//resources//bluechip.png"));
        fiveBet.setBounds(190, 580, 100, 100);
        fiveBet.setOpaque(false);
        fiveBet.setContentAreaFilled(false);
        fiveBet.setBorderPainted(false);
        fiveBet.addActionListener(this);
        background.add(fiveBet);
        
        tenBet = new JButton(new ImageIcon("..//BlackJack2.0//resources//tenchip.png"));
        tenBet.setBounds(300, 580, 100, 100);
        tenBet.setOpaque(false);
        tenBet.setContentAreaFilled(false);
        tenBet.setBorderPainted(false);
        tenBet.addActionListener(this);
        background.add(tenBet);
        
        twentyFiveBet = new JButton(new ImageIcon("..//BlackJack2.0//resources//blackchip.png"));
        twentyFiveBet.setBounds(410, 580, 100, 100);
        twentyFiveBet.setOpaque(false);
        twentyFiveBet.setContentAreaFilled(false);
        twentyFiveBet.setBorderPainted(false);
        twentyFiveBet.addActionListener(this);
        background.add(twentyFiveBet);
        
        //adds the deal button
        
	    deal = new JButton("Deal");
	    deal.setBounds(620, 5, 40, 40);
	    
	    deal.addActionListener(this);
        
        
        background.repaint();
	}
	

	/**
	 * Deals cards to player and dealer, alternating cards
	 */
	public void deal() {
		//remove button to deal
		background.remove(deal);
		background.remove(betAmount);
		background.remove(fiveBet);
		background.remove(tenBet);
		background.remove(twentyFiveBet);
		//adds hit button
		hit = new JButton("Hit"); 
		hit.setBounds(450, 500, 70, 20);
		hit.addActionListener(this);
		background.add(hit);
		
		//adds Double button
		doubleDown = new JButton("Double");
		doubleDown.setBounds(450, 520, 70, 20);
		doubleDown.addActionListener(this);
		background.add(doubleDown);
		
		//adds stand button
		stand = new JButton("Stand");
		stand.setBounds(450, 540, 70, 20);
		stand.addActionListener(this);
		background.add(stand);
		
		//new hands for dealer and player
		playerHand = new Hand(deck);
		dealerHand = new Hand(deck);
		
		//player card 1
		Card pCard1 = playerHand.getRandCard(deck);
		ImageIcon playerCardImage1 = new ImageIcon(pCard1.cardToImage());
		JButton card1 = new JButton(playerCardImage1); 
		card1.setBounds(560, 500, 80, 120);
		background.add(card1);	
		
		//dealer card 1
		Card dCard1 = dealerHand.getRandCard(deck);
		ImageIcon dealerCardImage1 = new ImageIcon(dCard1.cardToImage());
		JButton dealerCard1 = new JButton(dealerCardImage1); 
		dealerCard1.setBounds(560, 50, 80, 120);
		background.add(dealerCard1);
		
		//player card 2
		Card pCard2 = playerHand.getRandCard(deck);
		ImageIcon playerCardImage2 = new ImageIcon(pCard2.cardToImage());
		JButton card2 = new JButton(playerCardImage2);
		card2.setBounds(640, 500, 80, 120);
		background.add(card2);
		cardLocation +=640; //player initial card location set
		
		
		//dealer card 2
		dCard2 = dealerHand.getRandCard(deck);
		ImageIcon dealerCardImage2 = new ImageIcon("..//BlackJack2.0//resources//JPEG//Red_Back.jpg");
		dealerCard2 = new JButton(dealerCardImage2);
		dealerCard2.setBounds(640, 50, 80, 120);
		background.add(dealerCard2);
		dealerCardLocation +=640; //dealer initial card location set

		//number At label
		numAt = new JLabel(playerHand.statusOfHand());
		numAt.setBounds(450, 470, 100, 30);
		background.add(numAt);
		
		//if the player has blackjack it is automatically the dealers turn
		if(playerHand.statusOfHand().equals("BLACKJACK!")) {
			dealerTurn();
		}
		
		background.repaint();
	}
	
	/**
	 * "Hit" in blackjack which gives the player another card.
	 */
	public void hit() {
		//random new card from the deck
		Card nextCard = playerHand.getRandCard(deck);
		ImageIcon nextCardImage = new ImageIcon(nextCard.cardToImage());
		cardLocation += 80; //puts the card to the right of the previous card
		JButton newCard = new JButton(nextCardImage);
		newCard.setBounds(cardLocation,500, 80, 120);
		background.add(newCard);
		
		//updates the number at label
		numAt.setText(playerHand.statusOfHand());
		
		//if the player is done, it is the dealers turn
		if(playerHand.endOfTurn()) {
			dealerTurn();
		}
		
		background.repaint();
	}
	
	public void doubleDown() {
		hit();
		dealerTurn();
	}
	
	/**
	 * does the dealers turn. In blackjack the dealer must hit until their number is at least 17. 
	 * They also have to stand at 17 or higher. The dealers 2nd card isn't shown until the player is done.
	 */
	public void dealerTurn() {
		//remove player options
		background.remove(hit);
		background.remove(stand);
		background.remove(doubleDown);
		
		//change dealers 2nd card to a actual card
		dealerCard2.setIcon(new ImageIcon(dCard2.cardToImage()));
		dealerNumAt = new JLabel("Dealer has: " +dealerHand.statusOfHand());
		dealerNumAt.setBounds(400, 100, 150, 30);
		background.add(dealerNumAt);
		
		//until the dealer is at 17, hit.
		while(dealerHand.getNumberAt() < 17) {
			dealerHit();
		}
		
		//adds button to start new game after the dealer is done.
		newGame = new JButton("New Game");
		newGame.setBounds(600, 5, 80, 40);
		newGame.addActionListener(this);
		background.add(newGame);
		
		//adds label which tells user if they won, lost, or push(tie)
		JLabel gameOver = new JLabel(determineOutcome());
		gameOver.setBounds(450, 500, 100, 30);
		background.add(gameOver);
		
		background.repaint();
	}
    
	/**
	 * Gives the dealer another card.
	 */
	public void dealerHit() {
		//random card from the deck
		Card nextCard = dealerHand.getRandCard(deck);
		ImageIcon nextCardImage = new ImageIcon(nextCard.cardToImage());
		dealerCardLocation += 80; //puts the card to the right of the previous card
		JButton newCard = new JButton(nextCardImage);
		newCard.setBounds(dealerCardLocation,50, 80, 120);
		background.add(newCard);
		
		//updates the number the dealer is at
		dealerNumAt.setText("Dealer has: " +dealerHand.statusOfHand());
		
		background.repaint();
	}
	
	/**
	 * determines if the user wins, loses, or push(tie).
	 * @return string representation of the result
	 */
	public String determineOutcome() {
		
		
		if(playerHand.statusOfHand().equals("BLACKJACK!") || playerHand.getNumberAt() > dealerHand.getNumberAt() && 
				playerHand.getNumberAt() <= 21 || dealerHand.statusOfHand().equals("BUST!") && playerHand.getNumberAt() <= 21) {
			chips.betWin();
			outcomeOfBet();
			return "YOU WIN!";
		}else if(playerHand.statusOfHand().equals("BLACKJACK!")) {
			chips.blackJackWin();
			outcomeOfBet();
			return "YOU WIN!";
		}
		else if(playerHand.statusOfHand().equals("BUST!") || playerHand.getNumberAt() < dealerHand.getNumberAt() && dealerHand.getNumberAt() <=21) {
			outcomeOfBet();
			return "YOU LOSE!";
		
		}
		chips.returnChips();
		outcomeOfBet();
		return "PUSH!";
					
	}
	
	/**
	 * restarts the game
	 */
	public void resetGame() {
		//clear components
		background.removeAll();
		
		//creates a new game with a new deck.
		new Display(new Deck(), frame, chips);
		
		background.repaint();
		
	}
	
	public void outcomeOfBet() {
		chips.resetBet();
		totalMoney.setText("Balance: " +chips.getAmountOfChips());
		currBet.setText("Bet Amount: " +chips.getCurrentBet());
		background.repaint();
	}
	
	public void betChips(int amount) {
		background.add(deal);
		chips.betChips(amount);
		totalMoney.setText("Balance: " +chips.getAmountOfChips());
		currBet.setText("Bet Amount: " +chips.getCurrentBet());
		background.repaint();
	}
	/**
	 * action listener that uses the buttons 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deal) {
			deal();
		}
		if(e.getSource() == hit) {
			hit();
		}
		if(e.getSource() == stand) {
			dealerTurn();
		}
		if(e.getSource() == newGame) {
			resetGame();
		}
		if(e.getSource() == doubleDown) {
			doubleDown();
		}
		if(e.getSource() == fiveBet) {
			betChips(5);
		}
		if(e.getSource() == tenBet) {
			betChips(10);
		}
		if(e.getSource() == twentyFiveBet) {
			betChips(25);
		}
		
	}

	
}
