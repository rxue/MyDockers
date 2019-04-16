package com.rx.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.rx.entity.Shop;

public interface ShopRepository extends MongoRepository<Shop, Integer> {
}
