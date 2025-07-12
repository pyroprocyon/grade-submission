package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Course;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

  Optional<Course> findBySubjectAndCode(String subject, String code);
}
