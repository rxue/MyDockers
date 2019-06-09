package com.rx.entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection="cities")
public class City extends BaseEntity {
	private String country;
	@NotNull(message="city cannot be empty")
	private String city;
	
}