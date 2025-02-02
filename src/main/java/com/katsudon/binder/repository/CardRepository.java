package com.katsudon.binder.repository;

import com.katsudon.binder.model.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CardRepository extends MongoRepository<Card, String> {

}
