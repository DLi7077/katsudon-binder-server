package com.katsudon.binder.repository;

import com.katsudon.binder.model.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, String> {
}
