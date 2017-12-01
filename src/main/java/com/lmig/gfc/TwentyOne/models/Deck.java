package com.lmig.gfc.TwentyOne.models;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();

	}

	public void createDeck() {
		for (Suits suit : Suits.values()) {

			deck.add(new AceCard(suit));
			for (int i = 2; i < 10; i += 1) {
				deck.add(new NumberCard(suit, i));
			}
			for (Faces face : Faces.values()) {
				deck.add(new FaceCard(suit, face));
			}
		}

	}

	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public int size() {
		return deck.size();
	}
	
	
	
	public Card draw() {
		return deck.remove(0);
		
		}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	 
	
	
}
