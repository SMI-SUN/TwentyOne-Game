package com.lmig.gfc.TwentyOne.models;

public class Game {
	// private static final String string_values = null;
	private Deck deck;
	private Player player;
	private Dealer dealer;
	private Bank bank;
	private int playerBet;

	public Game() {
		deck = new Deck();
		bank = new Bank();

		deck.createDeck();
		deck.createDeck();
		deck.createDeck();
		deck.createDeck();
		deck.shuffleDeck();

		player = new Player();
		dealer = new Dealer();

	}

	public void hitPlayer() {
		Card newCardFromDeck = deck.draw();
		player.accept(newCardFromDeck);

	}

	
	public void hitDealer() {
		Card newCardFromDeck = deck.draw();
		dealer.accept(newCardFromDeck);

	}

	public void hitDealerUntilDone() {
		while (dealer.getHandTotal() < 17) {
			hitDealer();
		}
	}

	
	public boolean didPlayerLose() {
		if (player.getHandTotal() > 21) {
			return true;
		} else {

			return false;
		}
	}
	//if (!player.isBusted() || (player.getHandTotal() == 21 && player.getHandTotal() > dealer.getHandTotal())) 
	public boolean didPlayerwin() {
		if (dealer.isBusted()) {
			return true;
		}
		if (!player.isBusted() && player.getHandTotal() > dealer.getHandTotal()) {
			return true;
		} else {

			return false;
		}
	}
	
	public boolean isBlackJack() {
		if (player.getHandSize() ==2 && player.getHandTotal() == 21) {
			return true;
		}
		return false;
		
	}

	public boolean didDealerWin() {
		if (player.isBusted() || (dealer.getHandTotal() > player.getHandTotal() && !dealer.isBusted())) {
			return true;

		} else {

			return false;
		}

	}
	
	public boolean outOfCards() {
		return deck.size() == 0;
	}
	

	public int getPlayerBet() {

		return playerBet;
	}

	public void makePlayerBet(int bet) {
		playerBet = bet;
	}

	public void payout() {
		if (didPlayerwin() == true) {
			if (isBlackJack()) {
				bank.increaseAmountBy(playerBet * 1.5) ;
			} else  {
			bank.increaseAmountBy(playerBet);
			}
		} else if (player.isBusted() || didDealerWin()) {
			bank.reduceAmountBy(playerBet);
		}
	}

	public void setUpGame() {
		player.newHand();
		dealer.newHand();
		this.hitPlayer();
		this.hitPlayer();
		this.hitDealer();

	}

	public void resetGame() {
		player.newHand();
		dealer.newHand();
		this.setUpGame();
	}

}
