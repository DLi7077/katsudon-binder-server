package com.katsudon.binder.service;

import com.katsudon.binder.model.entity.Card;
import com.katsudon.binder.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
  final CardRepository cardRepository;

  public Card create(Card card) {
    return cardRepository.save(card);
  }

  public List<Card> find(List<String> rarity, List<String> set, String name,
                         String orderBy, String orderDir, int page, int pageSize) {
    boolean ascending = orderDir.compareTo("asc") > 0;
    Sort sort = ascending ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
    Pageable pageable = PageRequest.of(page, pageSize, sort);

    return cardRepository.findByRarityInAndSetInAndName(rarity, set, name, pageable);
  }
}
