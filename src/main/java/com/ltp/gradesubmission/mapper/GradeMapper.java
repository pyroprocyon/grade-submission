package com.ltp.gradesubmission.mapper;

import com.ltp.gradesubmission.dto.GradeDto;
import com.ltp.gradesubmission.entity.Grade;

public class GradeMapper {

  public static GradeDto gradeToDto(Grade grade) {
    return new GradeDto(
        grade.getId(),
        grade.getStudent().getName(),
        "%s - %s".formatted(
            grade.getCourse().getSubject(),
            grade.getCourse().getCode()),
        grade.getScore());
  }
}
