package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.dto.GradeDto;
import com.ltp.gradesubmission.entity.Grade;
import java.util.List;

public interface GradeService {

  GradeDto getGrade(Long studentId, Long courseId);

  GradeDto saveGrade(Grade grade, Long studentId, Long courseId);

  GradeDto updateGrade(Grade score, Long studentId, Long courseId);

  void deleteGrade(Long studentId, Long courseId);

  List<GradeDto> getStudentGrades(Long studentId);

  List<GradeDto> getCourseGrades(Long courseId);

  List<GradeDto> getAllGrades();
}
