package com.ltp.gradesubmission.validation;

import java.time.LocalDate;

public class EntityAlreadyExistException extends RuntimeException {

  public EntityAlreadyExistException(String name, LocalDate birthDate) {
    super("The student '%s' with birth date '%s' already exists in our records"
        .formatted(name, birthDate));
  }

  public EntityAlreadyExistException(String subject, String code) {
    super("The course '%s' with subject code '%s' already exists in our records"
        .formatted(subject, code));
  }
}
