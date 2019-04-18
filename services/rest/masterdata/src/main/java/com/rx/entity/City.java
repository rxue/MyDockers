package com.rx.entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cities")
public class City extends BaseEntity {
	private String country;
	@NotNull
	private String city;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}