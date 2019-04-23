package com.rx.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rx.entity.City;

public interface CityRepository extends MongoRepository<City, Integer> {
	public Optional<City> findByCountryAndCity(String country, String city);
	public List<City> findByCity(String cityW);
	public void deleteById(String id);
	//public void deleteByCity(String city);
	public default List<City> deleteByCity(String city) {
		List<City> cities = findByCity(city);
		cities.stream().forEach(c -> deleteById(c.getId()));
		return cities;
	}
}
