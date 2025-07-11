package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.dto.StudentDto;
import com.ltp.gradesubmission.entity.Student;
import java.util.List;

public interface StudentService {

  Student getStudent(Long id);

  Student saveStudent(StudentDto student);

  void deleteStudent(Long id);

  List<Student> getStudents();
}
