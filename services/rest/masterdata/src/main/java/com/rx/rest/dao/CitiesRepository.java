package com.rx.rest.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.rx.entity.City;

public interface CitiesRepository extends MongoRepository<City, Integer> {
}
