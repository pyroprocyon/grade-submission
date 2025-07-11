package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.dto.StudentDto;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService service;

  @GetMapping
  public ResponseEntity<List<Student>> getStudents() {
    return ResponseEntity.ok(service.getStudents());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable Long id) {
    return ResponseEntity.ok(service.getStudent(id));
  }

  @PostMapping
  public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
    service.deleteStudent(id);
    return ResponseEntity.noContent().build();
  }

}
