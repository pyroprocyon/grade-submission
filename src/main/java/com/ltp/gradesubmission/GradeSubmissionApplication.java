package com.ltp.gradesubmission;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GradeSubmissionApplication implements CommandLineRunner {

  private final StudentRepository studentRepository;
  private final CourseRepository courseRepository;

  public static void main(String[] args) {
    SpringApplication.run(GradeSubmissionApplication.class, args);
  }

  @Override
  public void run(String... args) {
    List<Student> students = List.of(
        new Student("Harry Potter", LocalDate.of(1980, 7, 31)),
        new Student("Ron Weasley", LocalDate.of(1980, 3, 1)),
        new Student("Hermione Granger", LocalDate.of(1979, 9, 19)),
        new Student("Neville Longbottom", LocalDate.of(1980, 7, 30))
    );
    studentRepository.saveAll(students);

    List<Course> courses = List.of(
        new Course("Charms", "CH104",
            "Learn spells concerned with giving an object new and unexpected properties."),
        new Course("Defence Against the Dark Arts", "DADA",
            "Learn defensive techniques against the dark arts."),
        new Course("Herbology", "HB311",
            "Study magical plants and how to care for, utilise, and combat them."),
        new Course("History of Magic", "HIS393",
            "Learn about significant events in wizarding history."),
        new Course("Potions", "POT102",
            "Mix and stir ingredients to create magical effects."),
        new Course("Transfiguration", "TR442",
            "Master the art of changing the form or appearance of an object.")
    );
    courseRepository.saveAll(courses);
  }

}
