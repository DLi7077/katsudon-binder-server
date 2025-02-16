package com.katsudon.binder.controller;

import com.katsudon.binder.model.entity.Card;
import com.katsudon.binder.model.entity.ExpansionSet;
import com.katsudon.binder.repository.CardRepository;
import com.katsudon.binder.repository.ExpansionRepository;
import com.katsudon.binder.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ReadController {
  final CardRepository cardRepository;
  final ExpansionRepository expansionRepository;
  final CardService cardService;

  @GetMapping("/penis")
  public String penis() {
    return "penis";
  }

  @GetMapping("/cards")
  public List<Card> findCards(@RequestParam(required = false) List<String> rarity,
                              @RequestParam(required = false) List<String> set,
                              @RequestParam(required = false) String name,
                              @RequestParam(defaultValue = "setReleaseDate") String orderBy,
                              @RequestParam(defaultValue = "desc") String orderDir,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "100") int pageSize) {
    return cardService.find(rarity, set, name, orderBy, orderDir, page, pageSize);
  }

  @GetMapping("/expansion")
  public List<ExpansionSet> findExpansions() {
    return expansionRepository.findAll();
  }
}
