package ruixue.rest.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import ruixue.rest.entity.Shop;

public interface ShopsRepository extends MongoRepository<Shop, Integer> {
}
