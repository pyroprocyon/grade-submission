package com.ltp.gradesubmission;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GradeSubmissionApplication implements CommandLineRunner {

  private final StudentRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(GradeSubmissionApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<Student> students = new ArrayList<>(List.of(
        new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
        new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
        new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
        new Student("Neville Longbottom", LocalDate.parse(("1980-07-30")))));

    repository.saveAll(students);
  }

}
