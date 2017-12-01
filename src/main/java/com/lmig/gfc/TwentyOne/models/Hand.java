package com.lmig.gfc.TwentyOne.models;
import java.util.LinkedList;
import java.util.List;

public class Hand {

	private LinkedList<Card> cards;

	public Hand() {
		cards = new LinkedList<Card>();
	}

	public void accept(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getTotal() {
		int sum = 0;
		int aces = 0;
		for (Card card : cards) {

			if (card.getValue() == 11)
				aces += 1;

			sum += card.getValue();
		}

		if (sum > 21) {
			while (aces > 0 && sum > 21) {

				sum -= 10; // always subtract 10 when Ace in the hand and hand > 21
				aces -= 1; // count value as 11

			}
		}

		return sum;
	}

	public boolean isBusted() {
		return getTotal() > 21;
	}

	public boolean isNotBusted() {
		return getTotal() < 21;
	}

	public String getBusted() {
		if (getTotal() > 21) {
			return "Busted!";
		} else {
			return "";
		}
	}

	public int getSize() {

		return cards.size();

	}

}
