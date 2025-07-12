package com.ltp.gradesubmission.exception;

public class EntityDoesNotExistException extends RuntimeException {

  public EntityDoesNotExistException(String entity, Long id) {
    super("%s with id '%d' does not exist in our records".formatted(entity, id));
  }

}
