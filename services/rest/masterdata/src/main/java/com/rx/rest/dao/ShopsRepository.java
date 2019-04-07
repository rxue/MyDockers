package com.rx.rest.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.rx.entity.Shop;

public interface ShopsRepository extends MongoRepository<Shop, Integer> {
}
