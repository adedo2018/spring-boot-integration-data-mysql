
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