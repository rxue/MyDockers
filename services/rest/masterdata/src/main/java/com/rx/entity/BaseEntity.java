package com.rx.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

public abstract class BaseEntity {
	@Id
	private BigInteger id;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	

}
