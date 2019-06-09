package com.rx.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public abstract class BaseEntity {
	@Id
	private String id;
}
