package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
	private JButton hit;
	private int cardLocation;
	private int dealerCardLocation;
	private Deck deck;
	private Hand playerHand;
	private Hand dealerHand;
	private JLabel numAt;
	private JButton reDeal;
	private JLabel background;
	
	public Display(Deck d) {
		this.deck = d; ///////newww
		// Creating instance of JFrame
        frame = new JFrame("Blackjack by Tony Nuss");
        // Setting the width and height of frame
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		//hit button
		hit = new JButton("Hit"); 
		hit.setBounds(450, 500, 70, 20);
		hit.addActionListener(this);
		background.add(hit);
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
		Card dCard2 = dealerHand.getRandCard(deck);
		ImageIcon dealerCardImage2 = new ImageIcon(dCard2.cardToImage());
		JButton dealerCard2 = new JButton(dealerCardImage2);
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

		background.repaint();
	}
	

    
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deal) {
			deal();
		}
		if(e.getSource() == hit) {
			hit();
		}
		
	}

	
}
