package com.katsudon.binder.service;

import com.katsudon.binder.model.entity.Card;
import com.katsudon.binder.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
  final CardRepository cardRepository;

  public Card create(Card card) {
    return cardRepository.save(card);
  }
}
