package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @NotBlank(message = "Subject cannot be blank")
  private String subject;

  @NonNull
  @NotBlank(message = "Code cannot be blank")
  private String code;

  @NonNull
  @NotBlank(message = "Description cannot be blank")
  private String description;

  @JsonIgnore
  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<Grade> grade;
}
