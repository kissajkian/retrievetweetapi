package com.twitter.kissajkian.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.kissajkian.dao.HashtagConfigDao;
import com.twitter.kissajkian.dao.OauthConfigDao;
import com.twitter.kissajkian.dao.TweetHistoryDao;
import com.twitter.kissajkian.entity.RetrieveTweetOut;
import com.twitter.kissajkian.entity.Search;
import com.twitter.kissajkian.entity.Tweet;
import com.twitter.kissajkian.model.HashtagConfig;
import com.twitter.kissajkian.model.OauthConfig;
import com.twitter.kissajkian.model.TweetHistory;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Service
public class RetrieveTweetServiceImpl implements RetrieveTweetService{

	@Autowired
	private HashtagConfigDao hashtagConfigDao;
	
	@Autowired
	private OauthConfigDao oauthConfigDao;
	
	@Autowired
	private TweetHistoryDao tweetHistoryDao;
	
	public RetrieveTweetOut doExecution() throws TwitterException, SQLException, ClassNotFoundException {
			
		List<OauthConfig> oauths = oauthConfigDao.findAll();
		
		AccessToken accessToken = new AccessToken(oauths.get(0).getAccessToken(), oauths.get(0).getAccessSecrect());
		
		Twitter twitter = TwitterFactory.getSingleton();
			twitter.setOAuthConsumer(oauths.get(0).getConsumerKey(), oauths.get(0).getConsumerSecrect());
			twitter.setOAuthAccessToken(accessToken);
		
		return retrieveByKeywords(twitter);			
	}
	
	private RetrieveTweetOut retrieveByKeywords(Twitter twitter) throws TwitterException, SQLException, ClassNotFoundException {
		
		RetrieveTweetOut out = new RetrieveTweetOut();
			List<Search> listSearch = new ArrayList<Search>();
		out.setResearches(listSearch);
		
		for(HashtagConfig hashtag : hashtagConfigDao.findAll()) {
			
			Search search = new Search();
				search.setHashtag(hashtag.getHashtagConfig());
			
			List<Tweet> tweets = new ArrayList<Tweet>();
				search.setTweets(tweets);
				
			QueryResult result = executeQuery(twitter, hashtag.getHashtagConfig());			
			
			for(Status status : result.getTweets()) {											
				
				Tweet tweet = new Tweet();
					
					if(status.getUser() != null && status.getUser().getScreenName() != null) {
						tweet.setUserName(status.getUser().getScreenName());
					}						
					
					if(status.getText() != null) {
						tweet.setTweet(status.getText());
					}						
										
					if(status.getUser() != null && status.getUser().getFollowersCount() != 0)
						tweet.setFollowers(status.getUser().getFollowersCount());
					
					if(status.getUser() != null && status.getUser().getLocation() != null)
						tweet.setLocation(status.getUser().getLocation());
					
					if(status.getCreatedAt() != null) {
						Timestamp createdAt = new Timestamp(status.getCreatedAt().getTime());	
						tweet.setCreatedAt(createdAt);
					}
					
					saveHistory(hashtag.getHashtagConfig(), tweet);
					
				search.getTweets().add(tweet);
			}
			
			out.getResearches().add(search);
		}			
		
		return out;
	}
	
	private QueryResult executeQuery(Twitter twitter, String keyword) throws TwitterException {
		Query query = new Query(keyword);
		
		return twitter.search(query);
	}
	
	private void saveHistory(String hashtag, Tweet tweet) {
		
		TweetHistory entity = new TweetHistory();
			if(hashtag != null)
				entity.setHashtag(hashtag);
			if(tweet.getUserName() != null)
				entity.setUserName(tweet.getUserName());
			if(tweet.getTweet() != null)
				entity.setTweet(tweet.getTweet());			
			entity.setFollowers((long) tweet.getFollowers());
			if(tweet.getLocation() != null)
				entity.setLocation(tweet.getLocation());
			if(tweet.getCreatedAt() != null)
				entity.setCreatedAt(tweet.getCreatedAt());		
		tweetHistoryDao.save(entity);		
	}
}