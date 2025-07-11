package com.ltp.gradesubmission.mapper;

import com.ltp.gradesubmission.dto.StudentDto;
import com.ltp.gradesubmission.entity.Student;

public class StudentMapper {

  public static Student dtoToStudent(StudentDto dto) {
    return new Student(dto);
  }

}
