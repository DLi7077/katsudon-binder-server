package com.katsudon.binder.controller;

import com.katsudon.binder.model.entity.Card;
import com.katsudon.binder.model.entity.ExpansionSet;
import com.katsudon.binder.repository.CardRepository;
import com.katsudon.binder.repository.ExpansionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seed")
@RequiredArgsConstructor
public class SeedController {

  final CardRepository cardRepository;
  final ExpansionRepository expansionRepository;

  @PostMapping("/cards")
  public List<Card> createCards(@RequestBody List<Card> cards) {
    return cardRepository.saveAll(cards);
  }

  @PostMapping("/expansion")
  public List<ExpansionSet> createExpansion(@RequestBody List<ExpansionSet> expansionSets) {
    return expansionRepository.saveAll(expansionSets);
  }
}
