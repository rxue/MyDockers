package com.rx.rest.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import ruixue.rest.entity.Shop;

public interface ShopsRepository extends MongoRepository<Shop, Integer> {
}
