package com.ltp.gradesubmission.exception;

public class EntityDoesNotExistException extends RuntimeException {

  public EntityDoesNotExistException(String entity, Long id) {
    super("%s with ID '%d' does not exist in our records"
        .formatted(entity, id));
  }

  public EntityDoesNotExistException(Long studentId, Long courseId) {
    super("A grade for student ID '%d' and course ID '%d' does not exist in our records"
        .formatted(studentId, courseId));
  }
}
