package com.lmig.gfc.TwentyOne.models;


public class Player {
	
	private Hand hand;
	private Bank cash;
	
	public Player() {
		
		hand = new Hand();
		cash = new Bank();
		
	}
	
	
	public void newHand() {
		hand = new Hand();
	}
	
	

	public void accept(Card newCardFromDeck) {
		hand.accept(newCardFromDeck);
				
	}
	
	public void accept(Bank cash) {
		this.accept(cash);
	}
	
	public Bank getBank(Bank bank) {
		return cash;
	}
	
	public void setBank(Bank bank) {
		this.cash = bank;
	}

	public int getHandTotal() {
		return hand.getTotal();
	}
	
	public boolean isBusted() {
		return hand.getTotal() > 21;
	}
	
	public int getHandSize() {
		return hand.getSize();
	}
}

