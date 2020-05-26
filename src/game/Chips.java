package game;

public class Chips {

	private double amountOfChips;
	
	private double currentBet;
	
	public Chips(int money) {
		amountOfChips = money;
		currentBet = 0;
	}
	
	public void returnChips() {
		amountOfChips += currentBet;
	}
	
	public void betChips(int amount) {
		if(amountOfChips >= amount) {
			amountOfChips = Math.max(amountOfChips - amount, 0);
			currentBet += amount;
		}
	}
	
	public void betWin() {
		amountOfChips += currentBet*2;
	}
	
	public void blackJackWin() {
		amountOfChips += currentBet + (currentBet*1.5);
	}
	
	public void resetBet() {
		currentBet = 0;
	}
	public double getAmountOfChips() {
		return amountOfChips;
	}
	
	public double getCurrentBet() {
		return currentBet;
	}
}
