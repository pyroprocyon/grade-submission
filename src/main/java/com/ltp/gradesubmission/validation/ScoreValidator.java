package com.ltp.gradesubmission.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class ScoreValidator implements ConstraintValidator<Score, String> {

  List<String> validScores = List.of(
      "A+", "A", "A-",
      "B+", "B", "B-",
      "C+", "C", "C-",
      "D+", "D", "D-",
      "F");

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }
    return validScores.contains(value.trim().toUpperCase());
  }
}
