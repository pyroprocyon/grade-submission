package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

  List<Grade> findByStudentId(Long student);
}
