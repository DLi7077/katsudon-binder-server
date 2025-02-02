package com.katsudon.binder.controller;

import com.katsudon.binder.model.entity.Card;
import com.katsudon.binder.model.entity.ExpansionSet;
import com.katsudon.binder.repository.CardRepository;
import com.katsudon.binder.repository.ExpansionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ReadController {
  final CardRepository cardRepository;
  final ExpansionRepository expansionRepository;

  @GetMapping("/cards")
  public List<Card> findCards() {
    return cardRepository.findAll();
  }

  @GetMapping("/expansion")
  public List<ExpansionSet> findExpansions() {
    return expansionRepository.findAll();
  }
}
