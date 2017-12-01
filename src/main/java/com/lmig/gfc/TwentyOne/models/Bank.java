package com.lmig.gfc.TwentyOne.models;

public class Bank {

	private double cash;
	

	public Bank() {    //constructor
		cash = 100.00;
	}

	public double getCash() {
		
		return cash;
	}
	
	public void reduceAmountBy(int value) {
		cash = cash - value;
	}
	
	public void increaseAmountBy(double d) {
		cash = cash + d;
	
	}


}
