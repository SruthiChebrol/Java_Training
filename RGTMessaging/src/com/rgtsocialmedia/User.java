package com.rgtsocialmedia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class User {
	private String username;
	private String password;
	private String name; 
	private String bio;
	private Set<String> followings;
	private Set<String> followers; 
	private List<String> tweets;
	Tweet tweet;
	public Set<String> getFollowings() {
		return followings;
	}
	public void setFollowings(Set<String> followings) {
		this.followings = followings;
	}
	public Set<String> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<String> followers) {
		this.followers = followers;
	}
	public List<String> getTweets() {
		return tweets;
	}
	public void setTweets(List<String> tweets) {
		this.tweets = tweets;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User(String username, String password, String name, String bio) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.bio = bio;
		this.followings = new HashSet<String>();
		this.followers = new HashSet<String>();
		this.tweets = new ArrayList<String>();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	public void follow(User user) { 
		followings.add(user.getUsername());
		user.followers.add(username);
		System.out.println("You are successfully followed  "+ user.getUsername());
	
	}
	public void  unfollow(User user) {
		followings.remove(user.getUsername());
		user.followers.remove(username);
		System.out.println("You are successfully Unfollowed  "+ user.getUsername());
		
	}
	public void deleteTweet(String tweetId) {
		
		
		tweets.remove(tweetId);
		System.out.println("Removed tweet successfully");
	}
	public void postTweet(String tweetId) {
	   tweets.add(tweetId);
	}
	
}
