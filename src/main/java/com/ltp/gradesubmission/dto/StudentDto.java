package com.ltp.gradesubmission.dto;

import com.ltp.gradesubmission.entity.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotNull(message = "Birth date cannot be blank")
  @Past(message = "Birth date should be in the past")
  private LocalDate birthDate;

  public StudentDto(Student student) {
    this.name = student.getName();
    this.birthDate = student.getBirthDate();
  }
}
