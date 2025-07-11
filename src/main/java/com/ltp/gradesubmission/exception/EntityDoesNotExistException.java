package com.ltp.gradesubmission.exception;

public class EntityDoesNotExistException extends RuntimeException {

  public EntityDoesNotExistException(String entity, Long id) {
    super(String.format("%s with id '%d' does not exist in our records", entity, id));
  }
}
