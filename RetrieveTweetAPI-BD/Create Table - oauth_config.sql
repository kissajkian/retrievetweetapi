CREATE TABLE oauth_config(codigo int(4) AUTO_INCREMENT,
                          consumer_key varchar(200) NOT NULL,
						  consumer_secrect varchar(200) NOT NULL,
						  access_token varchar(200) NOT NULL,
						  access_secrect varchar(200) NOT NULL,
                          PRIMARY KEY (codigo));													 