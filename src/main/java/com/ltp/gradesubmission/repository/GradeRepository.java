package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

  List<Grade> findByStudentId(Long student);

  List<Grade> findByCourseId(Long courseId);

  Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

  void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}
