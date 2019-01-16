package com.rx.rest.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import ruixue.rest.entity.City;

public interface CitiesRepository extends MongoRepository<City, Integer> {
}
