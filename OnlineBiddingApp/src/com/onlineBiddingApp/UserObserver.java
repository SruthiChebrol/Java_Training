package com.onlineBiddingApp;

public class UserObserver implements Observer {
    private User user;
    
    public UserObserver(User user) {
        this.user = user;
    }
    

    public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void update(Item item) {
		if (item.getHighestBidder() != null && !item.getHighestBidder().equals(user)) {
			System.out.println("You have been outbid on item: " + item.getName());
		}
	}
}
