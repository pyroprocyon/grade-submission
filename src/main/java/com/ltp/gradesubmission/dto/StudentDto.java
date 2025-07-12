package com.ltp.gradesubmission.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDto {

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotNull(message = "Birth date cannot be blank")
  @Past(message = "Birth date should be in the past")
  private LocalDate birthDate;

}
