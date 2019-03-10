package com.twitter.kissajkian.service;

import java.sql.SQLException;

import com.twitter.kissajkian.entity.RetrieveTweetOut;

import twitter4j.TwitterException;

public interface RetrieveTweetService {

	public RetrieveTweetOut doExecution() throws TwitterException, SQLException, ClassNotFoundException;
	
}