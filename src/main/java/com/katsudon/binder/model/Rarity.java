package com.katsudon.binder.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Rarity {
  // String value mismatches are intended.
  SPECIAL_ILLUSTRATION_RARE("Special Illustration Rare"),
  ILLUSTRATION_RARE("Illustration Rare"),
  TRAINER_GALLERY_HOLO_RARE("Trainer Gallery Rare Holo"),
  PROMO("Promo"),
  V_HOLO_RARE("Rare Holo V"),
  VSTAR_HOLO_RARE("Rare Holo VSTAR"),
  ULTRA_RARE("Rare Ultra"),
  RAINBOW_RARE("Rare Rainbow"),
  SECRET_RARE("Rare Secret");

  final String label;

  @Override
  public String toString() {
    return label;
  }
}
