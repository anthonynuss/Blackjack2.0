package game;

import java.util.Random;

public class Card {
	 /**
	   * Constants for the four suits.
	   */
	  public enum Suit
	  {
	    CLUBS, DIAMONDS, HEARTS, SPADES
	  };

	  /**
	   * Suit for this card.
	   */
	  private final Suit suit;

	  /**
	   * Rank for this card.
	   */
	  private final int rank;
	
	  public Card(int givenRank, Suit givenSuit)
	  {
	    rank = givenRank;
	    suit = givenSuit;
	  }
	  
	  
	  public int getRandRank() {
		  Random rand = new Random();
		  return rand.nextInt(10)+1;
	  }

	  /**
	   * Returns the rank for this card.
	   * 
	   * @return rank for this card
	   */
	  public int getRank()
	  {
	    return rank;
	  }

	  /**
	   * Returns the suit for this card.
	   * 
	   * @return suit for this card
	   */
	  public Suit getSuit()
	  {
	    return suit;
	  }
	  
	  public String cardToImage() {
		  if(getSuit().toString().equals("HEARTS")) {
			  if(getRank()==1)
				  return "..//BlackJack2.0//resources//JPEG//AH.jpg";
			  if(getRank()==2) 
				  return"..//BlackJack2.0//resources//JPEG//2H.jpg";
			  if(getRank()==3)
				  return "..//BlackJack2.0//resources//JPEG//3H.jpg";
			  if(getRank()==4)
				  return "..//BlackJack2.0//resources//JPEG//4H.jpg";
			  if(getRank()==5)
				  return "..//BlackJack2.0//resources//JPEG//5H.jpg";
			  if(getRank()==6)
				  return "..//BlackJack2.0//resources//JPEG//6H.jpg";
			  if(getRank()==7)
				  return "..//BlackJack2.0//resources//JPEG//7H.jpg";
			  if(getRank()==8)
				  return "..//BlackJack2.0//resources//JPEG//8H.jpg";
			  if(getRank()==9)
				  return "..//BlackJack2.0//resources//JPEG//9H.jpg";
			  if(getRank()==10)
				  return "..//BlackJack2.0//resources//JPEG//10H.jpg";
			  if(getRank()==11)
				  return "..//BlackJack2.0//resources//JPEG//JH.jpg";
			  if(getRank()==12)
				  return "..//BlackJack2.0//resources//JPEG//QH.jpg";
			  if(getRank()==13) 
				  return "..//BlackJack2.0//resources//JPEG//KH.jpg";  
		  }
		  else if(getSuit().toString().equals("DIAMONDS")) {
			  if(getRank()==1)
				  return "..//BlackJack2.0//resources//JPEG//AD.jpg";
			  if(getRank()==2) 
				  return"..//BlackJack2.0//resources//JPEG//2D.jpg";
			  if(getRank()==3)
				  return "..//BlackJack2.0//resources//JPEG//3D.jpg";
			  if(getRank()==4)
				  return "..//BlackJack2.0//resources//JPEG//4D.jpg";
			  if(getRank()==5)
				  return "..//BlackJack2.0//resources//JPEG//5D.jpg";
			  if(getRank()==6)
				  return "..//BlackJack2.0//resources//JPEG//6D.jpg";
			  if(getRank()==7)
				  return "..//BlackJack2.0//resources//JPEG//7D.jpg";
			  if(getRank()==8)
				  return "..//BlackJack2.0//resources//JPEG//8D.jpg";
			  if(getRank()==9)
				  return "..//BlackJack2.0//resources//JPEG//9D.jpg";
			  if(getRank()==10)
				  return "..//BlackJack2.0//resources//JPEG//10D.jpg";
			  if(getRank()==11)
				  return "..//BlackJack2.0//resources//JPEG//JD.jpg";
			  if(getRank()==12)
				  return "..//BlackJack2.0//resources//JPEG//QD.jpg";
			  if(getRank()==13) 
				  return "..//BlackJack2.0//resources//JPEG//KD.jpg"; 
		  }
		  else if(getSuit().toString().equals("CLUBS")) {
			  if(getRank()==1)
				  return "..//BlackJack2.0//resources//JPEG//AC.jpg";
			  if(getRank()==2) 
				  return"..//BlackJack2.0//resources//JPEG//2C.jpg";
			  if(getRank()==3)
				  return "..//BlackJack2.0//resources//JPEG//3C.jpg";
			  if(getRank()==4)
				  return "..//BlackJack2.0//resources//JPEG//4C.jpg";
			  if(getRank()==5)
				  return "..//BlackJack2.0//resources//JPEG//5C.jpg";
			  if(getRank()==6)
				  return "..//BlackJack2.0//resources//JPEG//6C.jpg";
			  if(getRank()==7)
				  return "..//BlackJack2.0//resources//JPEG//7C.jpg";
			  if(getRank()==8)
				  return "..//BlackJack2.0//resources//JPEG//8C.jpg";
			  if(getRank()==9)
				  return "..//BlackJack2.0//resources//JPEG//9C.jpg";
			  if(getRank()==10)
				  return "..//BlackJack2.0//resources//JPEG//10C.jpg";
			  if(getRank()==11)
				  return "..//BlackJack2.0//resources//JPEG//JC.jpg";
			  if(getRank()==12)
				  return "..//BlackJack2.0//resources//JPEG//QC.jpg";
			  if(getRank()==13) 
				  return "..//BlackJack2.0//resources//JPEG//KC.jpg"; 
		  }
		  else if(getSuit().toString().equals("SPADES")) {
			  if(getRank()==1)
				  return "..//BlackJack2.0//resources//JPEG//AS.jpg";
			  if(getRank()==2) 
				  return"..//BlackJack2.0//resources//JPEG//2S.jpg";
			  if(getRank()==3)
				  return "..//BlackJack2.0//resources//JPEG//3S.jpg";
			  if(getRank()==4)
				  return "..//BlackJack2.0//resources//JPEG//4S.jpg";
			  if(getRank()==5)
				  return "..//BlackJack2.0//resources//JPEG//5S.jpg";
			  if(getRank()==6)
				  return "..//BlackJack2.0//resources//JPEG//6S.jpg";
			  if(getRank()==7)
				  return "..//BlackJack2.0//resources//JPEG//7S.jpg";
			  if(getRank()==8)
				  return "..//BlackJack2.0//resources//JPEG//8S.jpg";
			  if(getRank()==9)
				  return "..//BlackJack2.0//resources//JPEG//9S.jpg";
			  if(getRank()==10)
				  return "..//BlackJack2.0//resources//JPEG//10S.jpg";
			  if(getRank()==11)
				  return "..//BlackJack2.0//resources//JPEG//JS.jpg";
			  if(getRank()==12)
				  return "..//BlackJack2.0//resources//JPEG//QS.jpg";
			  if(getRank()==13) 
				  return "..//BlackJack2.0//resources//JPEG//KS.jpg"; 
		  }
		  return Integer.toString(rank);
	  }

}
