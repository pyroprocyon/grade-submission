package com.ltp.gradesubmission.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class ErrorResponse {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private final LocalDateTime timestamp;
  private final List<String> message;

  public ErrorResponse(List<String> message) {
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }
}
