package com.katsudon.binder.service;

import com.katsudon.binder.model.entity.Card;
import com.katsudon.binder.repository.CardRepository;
import com.katsudon.binder.repository.CustomCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
  final CardRepository cardRepository;
  final CustomCardRepository customCardRepository;

  public Card create(Card card) {
    return cardRepository.save(card);
  }

  public List<Card> find(
          List<String> rarity, List<String> expansionSet,
          String name, String artist,
          String orderBy, String orderDir,
          int page, int pageSize
  ) {
    return customCardRepository.findCards(rarity, expansionSet, name, artist, orderBy, orderDir, page, pageSize);
  }
}
