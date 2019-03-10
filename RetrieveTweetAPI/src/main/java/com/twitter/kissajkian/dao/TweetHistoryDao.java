package com.twitter.kissajkian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.kissajkian.model.TweetHistory;

public interface TweetHistoryDao extends JpaRepository<TweetHistory, Long> {

}