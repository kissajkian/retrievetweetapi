package com.twitter.kissajkian.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.kissajkian.entity.RetrieveTweetOut;
import com.twitter.kissajkian.service.RetrieveTweetService;

import twitter4j.TwitterException;

@RestController
@RequestMapping("/retrieve/tweet")
public class RetrieveTweetController {

	@Autowired
	private RetrieveTweetService service;
	
	@GetMapping
	public RetrieveTweetOut retrieveTweetByHashtag() throws ClassNotFoundException, TwitterException, SQLException {
		return service.doExecution();
	}
}