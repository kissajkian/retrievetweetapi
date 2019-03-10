package com.twitter.kissajkian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.kissajkian.model.OauthConfig;

public interface OauthConfigDao extends JpaRepository<OauthConfig, Long> {

}