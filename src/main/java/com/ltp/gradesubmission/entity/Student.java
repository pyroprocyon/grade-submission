package com.ltp.gradesubmission.entity;

import com.ltp.gradesubmission.dto.StudentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private LocalDate birthDate;

  public Student(StudentDto dto) {
    this.name = dto.getName();
    this.birthDate = dto.getBirthDate();
  }

  public Student(String name, LocalDate birthDate) {
    this.name = name;
    this.birthDate = birthDate;
  }
}
