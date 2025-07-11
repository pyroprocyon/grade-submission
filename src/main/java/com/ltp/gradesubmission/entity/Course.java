package com.ltp.gradesubmission.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course {

  private Long id;
  private String subject;
  private String code;
  private String description;

}
