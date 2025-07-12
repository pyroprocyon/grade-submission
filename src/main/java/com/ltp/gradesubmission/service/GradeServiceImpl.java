package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

  private final GradeRepository gradeRepository;
  private final StudentService studentService;

  @Override
  public Grade getGrade(Long studentId, Long courseId) {
    return null;
  }

  @Override
  public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
    grade.setStudent(studentService.getStudent(studentId));
    return gradeRepository.save(grade);
  }

  @Override
  public Grade updateGrade(String score, Long studentId, Long courseId) {
    return null;
  }

  @Override
  public void deleteGrade(Long studentId, Long courseId) {
  }

  @Override
  public List<Grade> getStudentGrades(Long studentId) {
    return gradeRepository.findByStudentId(studentId);
  }

  @Override
  public List<Grade> getCourseGrades(Long courseId) {
    return null;
  }

  @Override
  public List<Grade> getAllGrades() {
    return gradeRepository.findAll();
  }

}
