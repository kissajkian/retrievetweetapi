package com.twitter.kissajkian.entity;

import java.sql.Timestamp;

public class Tweet {

	private String userName;
	private String tweet;
	private int followers;
	private String location;
	private Timestamp createdAt;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTweet() {
		return tweet;
	}
	
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	public int getFollowers() {
		return followers;
	}
	
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}	
}