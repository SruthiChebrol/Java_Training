package com.rgtsocialmedia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tweet {
	private String id;
	private String content;
	private String author; 
	private LocalDateTime timestamp;
	private int likeCount;
    private List<String> likedUsers;
    public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public List<String> getLikedUsers() {
		return likedUsers;
	}
	public void setLikedUsers(List<String> likedUsers) {
		this.likedUsers = likedUsers;
	}
	public List<Tweet> getRetweets() {
		return retweets;
	}
	public void setRetweets(List<Tweet> retweets) {
		this.retweets = retweets;
	}
	public List<Tweet> getReplies() {
		return replies;
	}
	public void setReplies(List<Tweet> replies) {
		this.replies = replies;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}




	private List<Tweet> retweets;
    private List<Tweet> replies;
    private User currentUser;
	
	public Tweet(String id, String content, String author, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.timestamp = timestamp;
		this.likeCount = 0;
        this.likedUsers = new ArrayList<>();
        this.retweets = new ArrayList<>();
        this.replies = new ArrayList<>();
        this.currentUser = null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public void like() {

        likeCount++;
        likedUsers.add(currentUser.getUsername());
        System.out.println("Tweet liked successfully.");
    }

 

    @Override
	public String toString() {
		return "Tweet [id=" + id + ", content=" + content + ", author=" + author + ", timestamp=" + timestamp
				+ ", likeCount=" + likeCount + ", likedUsers=" + likedUsers + ", retweets=" + retweets + ", replies="
				+ replies + ", currentUser=" + currentUser + "]";
	}
	public void retweet() {

        Tweet retweet = new Tweet(id, content, currentUser.getUsername(), LocalDateTime.now());
        retweets.add(retweet);
        System.out.println("Tweet retweeted successfully.");
    }

 


    public void reply(String replyContent) {
        Tweet reply = new Tweet(id, replyContent, currentUser.getUsername(), LocalDateTime.now());
        replies.add(reply);
        System.out.println("Tweet replied successfully.");
    }

}