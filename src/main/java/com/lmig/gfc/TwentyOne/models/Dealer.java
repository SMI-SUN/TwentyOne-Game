package com.lmig.gfc.TwentyOne.models;

public class Dealer {
  private Hand hand;
	
	public Dealer() {
		
		hand = new Hand();
		
	}
	
	
	public void newHand() {
		hand = new Hand();
	}

	public void accept(Card newCardFromDeck) {
		hand.accept(newCardFromDeck);
				
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
