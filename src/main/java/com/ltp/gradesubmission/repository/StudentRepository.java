package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Student;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findByNameAndBirthDate(String name, LocalDate birthDate);
}
