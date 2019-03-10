package com.twitter.kissajkian.entity;

import java.util.List;

public class Search {

	private String hashtag;
	private List<Tweet> tweets;
	
	public String getHashtag() {
		return hashtag;
	}
	
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}
	
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}	
}