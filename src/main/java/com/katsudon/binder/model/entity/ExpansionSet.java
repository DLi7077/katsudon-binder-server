package com.katsudon.binder.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.katsudon.binder.configuration.CustomJsonDateDeserializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("expansion-set")
@Data
public class ExpansionSet {

  @Id
  String id;
  String name;
  String series;
  String logoUrl;
  String iconUrl;
  Integer printedTotal;
  Integer totalCards;
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  LocalDateTime releaseDate;
}
