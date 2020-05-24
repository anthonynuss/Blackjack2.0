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

public class Display implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	
	private JButton deal;
	private JButton newGame;
	private JButton hit;
	private JButton stand;
	private int cardLocation;
	private int dealerCardLocation;
	private Deck deck;
	private Hand playerHand;
	private Hand dealerHand;
	private JLabel numAt;
	private JLabel dealerNumAt;

	private JLabel background;
	private Card dCard2;
	private JButton dealerCard2;
	
	public Display(Deck d, JFrame f) {
		this.deck = d;
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
        
        deal = new JButton("Deal");
        deal.setBounds(620, 5, 40, 40);
        background.add(deal);
        deal.addActionListener(this);
        background.repaint();
	}
	


	public void deal() {
		//remove button to deal
		background.remove(deal);
		//hit button
		hit = new JButton("Hit"); 
		hit.setBounds(450, 500, 70, 20);
		hit.addActionListener(this);
		background.add(hit);
		//stand button
		stand = new JButton("Stand");
		stand.setBounds(450, 520, 70, 20);
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
		cardLocation +=640;
		
		
		//dealer card 2
		dCard2 = dealerHand.getRandCard(deck);
		ImageIcon dealerCardImage2 = new ImageIcon("..//BlackJack2.0//resources//JPEG//Red_Back.jpg");
		dealerCard2 = new JButton(dealerCardImage2);
		dealerCard2.setBounds(640, 50, 80, 120);
		background.add(dealerCard2);
		dealerCardLocation +=640;

		
		//number At label
		numAt = new JLabel(playerHand.statusOfHand());
		numAt.setBounds(450, 470, 100, 30);
		background.add(numAt);
		
		
		background.repaint();
		
	}
	
	public void hit() {
		
		Card nextCard = playerHand.getRandCard(deck);
		ImageIcon nextCardImage = new ImageIcon(nextCard.cardToImage());
		cardLocation += 80;
		JButton newCard = new JButton(nextCardImage);
		newCard.setBounds(cardLocation,500, 80, 120);
		background.add(newCard);
		
		//change number at
		numAt.setText(playerHand.statusOfHand());
		if(playerHand.endOfTurn()) {
			dealerTurn();
		}
		background.repaint();
	}
	

	public void dealerTurn() {
		//remove player options
		background.remove(hit);
		background.remove(stand);
		
		//change dealers 2nd card to a actual card
		dealerCard2.setIcon(new ImageIcon(dCard2.cardToImage()));
		dealerNumAt = new JLabel("Dealer has: " +dealerHand.statusOfHand());
		dealerNumAt.setBounds(450, 100, 150, 30);
		background.add(dealerNumAt);
		
		while(dealerHand.getNumberAt() < 17) {
			dealerHit();
		}
		
		newGame = new JButton("New Game");
		newGame.setBounds(600, 5, 80, 40);
		newGame.addActionListener(this);
		background.add(newGame);
		
		JLabel gameOver = new JLabel(determineOutcome());
		gameOver.setBounds(450, 500, 100, 30);
		background.add(gameOver);
		background.repaint();
	}
    
	public void dealerHit() {
		Card nextCard = dealerHand.getRandCard(deck);
		ImageIcon nextCardImage = new ImageIcon(nextCard.cardToImage());
		dealerCardLocation += 80;
		JButton newCard = new JButton(nextCardImage);
		newCard.setBounds(dealerCardLocation,50, 80, 120);
		background.add(newCard);
		
		dealerNumAt.setText("Dealer has: " +dealerHand.statusOfHand());
		background.repaint();
	}
	
	public String determineOutcome() {
		if(playerHand.statusOfHand().equals("BUST!") || playerHand.getNumberAt() < dealerHand.getNumberAt()) {
			return "YOU LOSE!";
		}else if(playerHand.statusOfHand().equals("BLACKJACK!") || playerHand.getNumberAt() > dealerHand.getNumberAt()) {
			return "YOU WIN!";
		}
		return "PUSH!";
					
	}
	public void resetGame() {
		background.removeAll();
		deck = new Deck();
		new Display(new Deck(), frame);
		background.repaint();
		
	}
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
		
	}

	
}
