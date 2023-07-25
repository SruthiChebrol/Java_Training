package com.onlineBiddingApp;

import java.util.ArrayList;
import java.util.List;

public class ItemManagementService {
private Auction auction;
	
	private List<Item> items;


    public ItemManagementService() {
        this.auction = Auction.getInstance();
        this.items = new ArrayList<>();
        
        Item item1 = ItemFactory.createItem("Men's Jacket", " waterproof jacket", 1000.0);
        Item item2 = ItemFactory.createItem("Women's Columbia Jacket", "A warm and stylish jacket for women", 750.0);
        Item item3 = ItemFactory.createItem("Men Slim Mid Rise Light Blue Jeans","A Skinny fit with a waist & comfortably",600.0);
        Item item4 = ItemFactory.createItem("Men Slim Mid Rise Black Jeans","This fits snug on the thighs",700.0);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
    }


    public void addItem(String name, String description, double startingBid) {
    	
        Item item = ItemFactory.createItem(name, description, startingBid);
        auction.addItem(item);
        
    }

    public List<Item> searchItems(String keyword) {
    	List<Item> searchResults = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public Item getItemByName(String itemName) {
        
		for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Item not found
    }


 

  
}
