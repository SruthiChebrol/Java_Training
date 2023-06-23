package com.rgtsocialmedia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RGTMessaging {

	private Map<String, User> users;
	
    private List<Tweet> tweets = new ArrayList<Tweet>();
	
	private User currentUser;
	public Map<String, User> getUser() {
		return users;
	}

	public void setUser(Map<String, User> users) {
		this.users = users;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public RGTMessaging() {
		super();
		this.users = new HashMap<String, User>();
		this.currentUser = null;
	}
	
	Scanner scanner = new Scanner(System.in);
	public void registerUser() {
		System.out.println("Enter User Name : ");
		String userName = scanner.nextLine();
		if(users.containsKey(userName)) {
			System.out.println("User already exists, Please login");
			return;
		}
		System.out.println("Enter the password : ");
		String password = scanner.nextLine();
		
		System.out.println("Enter the Name : ");
		String name = scanner.nextLine();
		
		System.out.println("Enter bio : ");
		String bio = scanner.nextLine();
		
		User newUser = new User(userName, password, name, bio);
		users.put(userName, newUser);
		
		System.out.println("User added succesffully");
		
	}
	
    public void login() {
    	System.out.println("Enter the userName: ");
    	String userName = scanner.nextLine();
    	
    	System.out.println("Enter the password: ");
    	String password = scanner.nextLine();
    	
    	User user = users.get(userName);
    	if(user!=null&& user.getPassword().equals(password)) {
    		currentUser = user;
    		
    		System.out.println("Welcome to the RGT Messaging App"+ user.getUsername());
    		boolean logout = false;
    		while(!logout) {
    	  	
    		System.out.println("1. Post a Tweet");
    		System.out.println("2. Enter your timeline");
    		System.out.println("3. Search for a user");
    		System.out.println("4. Search for Tweets");
    		System.out.println("5. View your profile");
    		System.out.println("6. Logout");
    		System.out.print("Enter your choice : ");
    		int choice = scanner.nextInt();
    		
    		switch(choice) {
    		case 1 : 
    			postTweet();
    			break;
    		case 2 :
    			getTimeline(scanner);
    			break;
    		case 3 :
    			searchUser(scanner
    					);
    			break;
    		case 4 :
    			searchTweet(scanner);
    			break;
    		case 5 : 
    		    viewProfile();
    		    break;
    		case 6 :
    			logout = true;
    			System.out.println("Logging out "  + currentUser.getUsername());
    			currentUser = null;
    			System.out.println("LogOut successfully");
    			break;
    		default : 
    			System.out.println("Invalid Option......PLease try again");
    			break;
    			
    		}
    			
    		
    		
    		}
    		
    	}
    	
    	else {
    		System.out.println("Entered invalid userName and password");
    	}
    }
    
    public void searchUser(Scanner scanner) {
        System.out.println("Enter the username to search for:");
        String username = scanner.next();

        if (users.containsKey(username)) {
            User user = users.get(username);
            System.out.println("User found:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getName());
            System.out.println("Bio: " + user.getBio());
        } else {
            System.out.println("User not found.");
        }
    }
    
    public void viewProfile() {
    	System.out.println("User Profile");
        System.out.println("UserName -- "+currentUser.getUsername());
        System.out.println("UserBio --"+currentUser.getBio());
        System.out.println("User Following --"+currentUser.getFollowings().size());
        System.out.println("User Followers --"+currentUser.getFollowers().size());
        System.out.println("User Tweets count --"+currentUser.getTweets().size());
        System.out.println("User Tweets --"+currentUser.getTweets().toString());
        boolean back = false;
        while(!back) {
        	System.out.println("1.Follow user");
        	System.out.println("2.Unfollow user");
        	System.out.println("3. Exit");
        	int choice = scanner.nextInt();
        	switch(choice) {
        	case 1 :
        		System.out.println("Enter the userName : ");
            	String userName = scanner.next();
            	User user = users.get(userName);
            	if(user != null)
            		currentUser.follow(user);
        	    break;
        	case 2 :
        		System.out.println("Enter the userName : ");
            	String userName1 = scanner.next();
            	User user1 = users.get(userName1);
            	if(user1 != null)
            		currentUser.unfollow(user1);
                break;
        	case 3 :
        		back = true;
        		System.out.println("Back to profile");
        		break;
            default :
            	System.out.println("Invalid option");
        	}
        }
    	
    }
    public void postTweet() {
		System.out.println("Enter tweet id : ");
		String id = scanner.next();
		
		System.out.println("Enter tweet content : ");
		String content = scanner.next();
		
		
		Tweet tweet = new Tweet(id, content, currentUser.getUsername(), LocalDateTime.now());
		
		tweets.add(tweet);
		currentUser.postTweet(id);
		System.out.println("Tweet added successfully");
		
	}
    public void searchTweet(Scanner scanner) {
    	
        System.out.println("Enter the tweet ID to search for:");
        String tweetId = scanner.next();
            for (Tweet tweet : tweets) {
            if (tweet.getId().equals(tweetId)) {
                System.out.println("Tweet found:");
                System.out.println("ID: " + tweet.getId());
                System.out.println("Content: " + tweet.getContent());
                System.out.println("Author: " + tweet.getAuthor());
                System.out.println("Timestamp: " + tweet.getTimestamp());
                return;
            }
        }

 

        System.out.println("Tweet not found.");
    }
    public void getTimeline(Scanner scanner) {
    

    		 

            System.out.println("Timeline for user: " + currentUser.getUsername());
            for (Tweet tweet : tweets) {
                if (currentUser.getTweets().contains(tweet.getId())) {
                    System.out.println("ID: " + tweet.getId());
                    System.out.println("Content: " + tweet.getContent());
                    System.out.println("Author: " + tweet.getAuthor());
                    System.out.println("Timestamp: " + tweet.getTimestamp());
                    System.out.println("Likes: " + tweet.getLikedUsers().size());
                    System.out.println("Replies: " + tweet.getReplies().toString());
                    System.out.println("Retweets: " + tweet.getRetweets().toString());
                    System.out.println();
                }
                boolean back = false;
                while (!back) {
                    System.out.println("");
                    System.out.println("1. Like a tweet");
                    System.out.println("2. Retweet");
                    System.out.println("3. Reply to tweet");
                    System.out.println("4. Back to menu");
                    System.out.println("");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                    case 1:
                        System.out.println("Enter the tweetId of the tweet you want to like: ");
                        String tweetId = scanner.next();
                        for (Tweet tweet2 : tweets) {
                            if (tweet2 != null && tweet2.getId().equals(tweetId)) {
                                tweet2.setCurrentUser(currentUser);
                                tweet2.like();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the tweetId of the tweet you want to retweet: ");
                        String retweetId = scanner.next();
                        for (Tweet tweet2 : tweets) {
                            if (tweet2 != null && tweet2.getId().equals(retweetId)) {
                                tweet2.setCurrentUser(currentUser);
                                tweet2.retweet();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter the tweetId of the tweet you want to reply to: ");
                        String replyTweetId = scanner.next();
                        // scanner.next();
                        System.out.println("Enter your reply: ");
                        String replyContent = scanner.next();
                        for (Tweet tweet2 : tweets) {
                            if (tweet2 != null && tweet2.getId().equals(replyTweetId)) {
                                tweet2.setCurrentUser(currentUser);
                                tweet2.reply(replyContent);
                            }
                        }
                        break;
                    case 4:
                        back = true;
                        System.out.println("Returning to the menu.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                    }
                }
            }
    	}
    }

    
   

