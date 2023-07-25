package com.onlineBiddingApp;

public interface BiddingStrategy {
	public double bid(Item item, User user, double amount);
}