package com.katsudon.binder.repository;

import com.katsudon.binder.model.entity.Card;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomCardRepository {
    private final MongoTemplate mongoTemplate;

    public CustomCardRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Card> findCards(List<String> rarity, List<String> set, String name,
                                String orderBy, String orderDir, int page, int pageSize) {
        Query query = new Query();

        if (rarity != null && !rarity.isEmpty()) {
            query.addCriteria(Criteria.where("rarity").in(rarity));
        }
        if (set != null && !set.isEmpty()) {
            query.addCriteria(Criteria.where("expansionName").in(set));
        }
        if (name != null && !name.isEmpty()) {
            query.addCriteria(Criteria.where("name").regex(name, "i")); // Case-insensitive search
        }

        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        query.with(Sort.by(direction, orderBy));
        query.with(PageRequest.of(page - 1, pageSize));

        return mongoTemplate.find(query, Card.class);
    }
}
