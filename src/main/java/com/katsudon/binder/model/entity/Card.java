package com.katsudon.binder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("cards")
@Data
@Builder
@AllArgsConstructor
public class Card {

  @Id
  String id;
  String cardId;
  String name;
  String expansionId;
  String expansionName;
  String rarity;
  String imgUrlSmall;
  String imgUrlLarge;
  String artist;
  String tcgPlayerUrl;
  BigDecimal price;

}
