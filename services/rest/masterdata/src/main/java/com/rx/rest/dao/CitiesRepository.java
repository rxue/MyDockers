package com.rx.rest.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rx.entity.City;

public interface CitiesRepository extends MongoRepository<City, Integer> {
	public List<City> findByCity(String city);
	
	public default List<City> deleteByCity(String city) {
		List<City> cities = findByCity(city);
		cities.stream().forEach(c -> deleteById(c.getId()));
		return cities;
	}
}
