package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.dto.GradeDto;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.exception.EntityAlreadyExistException;
import com.ltp.gradesubmission.exception.EntityDoesNotExistException;
import com.ltp.gradesubmission.mapper.GradeMapper;
import com.ltp.gradesubmission.repository.GradeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

  private final GradeRepository gradeRepository;
  private final StudentService studentService;
  private final CourseService courseService;

  @Override
  public GradeDto getGrade(Long studentId, Long courseId) {
    Grade grade = fetchGrade(studentId, courseId);
    return GradeMapper.gradeToDto(grade);
  }

  @Override
  public GradeDto saveGrade(Grade grade, Long studentId, Long courseId) {
    if (gradeRepository.findByStudentIdAndCourseId(studentId, courseId).isPresent()) {
      throw new EntityAlreadyExistException(studentId, courseId);
    }
    grade.setStudent(studentService.getStudent(studentId));
    grade.setCourse(courseService.getCourse(courseId));
    Grade savedGrade = gradeRepository.save(grade);
    return GradeMapper.gradeToDto(savedGrade);
  }

  @Override
  public GradeDto updateGrade(Grade newGrade, Long studentId, Long courseId) {
    Grade grade = fetchGrade(studentId, courseId);
    grade.setScore(newGrade.getScore());
    return GradeMapper.gradeToDto(gradeRepository.save(grade));
  }

  @Override
  @Transactional
  public void deleteGrade(Long studentId, Long courseId) {
    gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
  }

  @Override
  public List<GradeDto> getStudentGrades(Long studentId) {
    return gradeRepository.findByStudentId(studentId).stream()
        .map(GradeMapper::gradeToDto)
        .toList();
  }

  @Override
  public List<GradeDto> getCourseGrades(Long courseId) {
    return gradeRepository.findByCourseId(courseId).stream()
        .map(GradeMapper::gradeToDto)
        .toList();
  }

  @Override
  public List<GradeDto> getAllGrades() {
    return gradeRepository.findAll().stream()
        .map(GradeMapper::gradeToDto)
        .toList();
  }

  private Grade fetchGrade(Long studentId, Long courseId) {
    return gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
        .orElseThrow(() -> new EntityDoesNotExistException(studentId, courseId));
  }

}
