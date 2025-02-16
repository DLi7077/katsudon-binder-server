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

    public List<Card> findCards(
            List<String> rarity, List<String> expansionSet,
            String name, String artist,
            String orderBy, String orderDir,
            int page, int pageSize
    ) {

        Query query = new Query();
        if (rarity != null && !rarity.isEmpty()) {
            query.addCriteria(Criteria.where("rarity").in(rarity));
        }
        if (expansionSet != null && !expansionSet.isEmpty()) {
            query.addCriteria(Criteria.where("expansionName").in(expansionSet));
        }
        if (name != null && !name.isEmpty()) {
            query.addCriteria(Criteria.where("name").regex(name, "i"));
        }
        if (artist != null && !artist.isEmpty()) {
            query.addCriteria(Criteria.where("artist").regex(artist, "i"));
        }

        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        query.with(Sort.by(direction, orderBy));
        query.with(PageRequest.of(page - 1, pageSize));

        return mongoTemplate.find(query, Card.class);
    }
}
