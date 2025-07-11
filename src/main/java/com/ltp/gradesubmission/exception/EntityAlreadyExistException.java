package com.ltp.gradesubmission.exception;

import java.time.LocalDate;

public class EntityAlreadyExistException extends RuntimeException {

  public EntityAlreadyExistException(String name, LocalDate birthDate) {
    super(String.format("The student '%s' with birth date '%s' already exists in our records", name,
        birthDate));
  }
}
