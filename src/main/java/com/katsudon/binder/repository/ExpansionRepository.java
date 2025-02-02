package com.katsudon.binder.repository;

import com.katsudon.binder.model.entity.ExpansionSet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpansionRepository extends MongoRepository<ExpansionSet, String> {

}
