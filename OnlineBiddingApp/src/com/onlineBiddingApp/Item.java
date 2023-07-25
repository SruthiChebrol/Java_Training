package com.onlineBiddingApp;

public class Item {
    private String name;
    private String description;
    private double currentHighestBid;
    private User highestBidder;

    public User getHighestBidder() {
		return highestBidder;
	}



	public void setHighestBidder(User highestBidder) {
		this.highestBidder = highestBidder;
	}



	public Item(String name, String description, double startingBid) {
        this.name = name;
        this.description = description;
        this.currentHighestBid = startingBid;
    }

 

        public void placeBid(User user, double bidAmount) {
        if (bidAmount > currentHighestBid) {
            currentHighestBid = bidAmount;
            highestBidder = user;
        }
        
        
    }

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getCurrentHighestBid() {
		return currentHighestBid;
	}



	public void setCurrentHighestBid(double currentHighestBid) {
		this.currentHighestBid = currentHighestBid;
	}



	
}
