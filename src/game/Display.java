package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Display {
	private static JFrame frame;
	private static JPanel panel;
	private static JButton deal;
	private static  JButton hit;
	private static int cardLocation;
	private static int dealerCardLocation;
	
	public Display() {
		// Creating instance of JFrame
        frame = new JFrame("Blackjack by Tony Nuss");
        // Setting the width and height of frame
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GREEN);
        panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        panel.setBackground(Color.GREEN);
        //placeComponents(panel);

        
        
        deal = new JButton("Deal");
        deal.setSize(20, 20);
        deal.setBounds(20, 20, 5, 5);
        deal.setLocation(10, 10);
        panel.add(deal);
        deal.addActionListener(new Action());
       
     // Setting the frame visibility to true
        frame.setVisible(true);
	}
	
	public static void deal() {
		//hit button
		hit = new JButton("Hit"); 
		hit.setBounds(450, 500, 70, 20);
		hit.addActionListener(new Action());
		panel.add(hit);
		
		//player card 1
		JButton card1 = new JButton("Card1"); 
		card1.setBounds(570, 500, 70, 100);
		panel.add(card1);
		//player card 2
		JButton card2 = new JButton("Card2"); 
		card2.setBounds(640, 500, 70, 100);
		panel.add(card2);
		cardLocation +=640;
		panel.repaint();
		
		//dealer card 1
		JButton dealerCard1 = new JButton("DealerCard1"); 
		dealerCard1.setBounds(570, 100, 70, 100);
		panel.add(dealerCard1);
		//dealer card 2
		JButton dealerCard2 = new JButton("DealerCard2"); 
		dealerCard2.setBounds(640, 100, 70, 100);
		panel.add(dealerCard2);
		dealerCardLocation +=640;
		panel.repaint();
	}
	
	public static void hit() {
		cardLocation += 70;
		JButton newCard = new JButton("new");
		newCard.setBounds(cardLocation,500, 70, 100);
		panel.add(newCard);
		panel.repaint();
	}
	static class Action implements ActionListener{     
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == deal) {
				deal();
			}
			if(e.getSource() == hit) {
				hit();
			}
			
		}
	}
	
}
