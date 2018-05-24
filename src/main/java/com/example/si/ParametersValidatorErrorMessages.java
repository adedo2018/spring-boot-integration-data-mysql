
/**
 * /*
 * (c) Copyright 2016 Brite:Bill Ltd.
 *
 * 7 Grand Canal Street Lower, Dublin 2, Ireland
 * info@britebill.com
 * +353 1 661 9426
 */
package com.example.si;


public enum ParametersValidatorErrorMessages {
  INVALID_BOOK_ID("invalid book id provided or retrieved");

  private final String description;

  ParametersValidatorErrorMessages(String description) {
    this.description = description;
  }

  public String getDescription() {
     return description;
  }

  @Override
  public String toString() {
    return description;
  }
}