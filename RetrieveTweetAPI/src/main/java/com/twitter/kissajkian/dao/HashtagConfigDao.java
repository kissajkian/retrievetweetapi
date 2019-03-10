package com.twitter.kissajkian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.kissajkian.model.HashtagConfig;

public interface HashtagConfigDao extends JpaRepository<HashtagConfig, Long> {

}