package com.ltp.gradesubmission.exception;

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

  public EntityAlreadyExistException(Long studentId, Long courseId) {
    super(
        "A grade already exists for student ID '%d' and course ID '%d'. Please update the existing record instead."
            .formatted(studentId, courseId));
  }
}
