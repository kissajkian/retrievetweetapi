CREATE TABLE tweet_history(codigo int(10) AUTO_INCREMENT,
                           hashtag varchar(30) NOT NULL,
						   user_Name varchar(200),
						   tweet varchar(500),
						   followers int(255),
						   location varchar(200),
						   created_at date,
						   PRIMARY KEY (codigo));