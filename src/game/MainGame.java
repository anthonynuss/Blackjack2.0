package game;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGame {
	public static void main(String args[]) {
		System.out.println("Starting game...");
		
		JFrame frame;
		JPanel panel;
		
		frame = new JFrame("Blackjack by Tony Nuss");
        // Setting the width and height of frame
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Deck deck = new Deck();
		Display display = new Display(deck, frame);
			

		
	}
}
