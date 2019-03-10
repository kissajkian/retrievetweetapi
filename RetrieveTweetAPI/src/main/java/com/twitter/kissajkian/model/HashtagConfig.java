package com.twitter.kissajkian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class HashtagConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotEmpty
	@Size(max = 30)
	@Column(name = "hashtag_config")
	private String hashtagConfig;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getHashtagConfig() {
		return hashtagConfig;
	}

	public void setHashtagConfig(String hashtagConfig) {
		this.hashtagConfig = hashtagConfig;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((hashtagConfig == null) ? 0 : hashtagConfig.hashCode());
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
		HashtagConfig other = (HashtagConfig) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (hashtagConfig == null) {
			if (other.hashtagConfig != null)
				return false;
		} else if (!hashtagConfig.equals(other.hashtagConfig))
			return false;
		return true;
	}

	
}