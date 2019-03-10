package com.twitter.kissajkian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class OauthConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotEmpty
	@Size(max = 200)
	@Column(name = "consumer_key")
	private String consumerKey;
	
	@NotEmpty
	@Size(max = 200)
	@Column(name = "consumer_secrect")
	private String consumerSecrect;
	
	@NotEmpty
	@Size(max = 200)
	@Column(name = "access_token")
	private String accessToken;
	
	@NotEmpty
	@Size(max = 200)
	@Column(name = "access_secrect")
	private String accessSecrect;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecrect() {
		return consumerSecrect;
	}

	public void setConsumerSecrect(String consumerSecrect) {
		this.consumerSecrect = consumerSecrect;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessSecrect() {
		return accessSecrect;
	}

	public void setAccessSecrect(String accessSecrect) {
		this.accessSecrect = accessSecrect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessSecrect == null) ? 0 : accessSecrect.hashCode());
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((consumerKey == null) ? 0 : consumerKey.hashCode());
		result = prime * result + ((consumerSecrect == null) ? 0 : consumerSecrect.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OauthConfig other = (OauthConfig) obj;
		if (accessSecrect == null) {
			if (other.accessSecrect != null)
				return false;
		} else if (!accessSecrect.equals(other.accessSecrect))
			return false;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (consumerKey == null) {
			if (other.consumerKey != null)
				return false;
		} else if (!consumerKey.equals(other.consumerKey))
			return false;
		if (consumerSecrect == null) {
			if (other.consumerSecrect != null)
				return false;
		} else if (!consumerSecrect.equals(other.consumerSecrect))
			return false;
		return true;
	}
}