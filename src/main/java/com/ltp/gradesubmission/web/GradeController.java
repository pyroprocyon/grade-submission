package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.dto.GradeDto;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.service.GradeService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

  private final GradeService service;

  @GetMapping
  public ResponseEntity<List<GradeDto>> getGrades() {
    return ResponseEntity.ok(service.getAllGrades());
  }

  @GetMapping("/students/{studentId}")
  public ResponseEntity<List<GradeDto>> getStudentGrades(@PathVariable Long studentId) {
    return ResponseEntity.ok(service.getStudentGrades(studentId));
  }

  @GetMapping("/courses/{courseId}")
  public ResponseEntity<List<GradeDto>> getCourseGrades(@PathVariable Long courseId) {
    return ResponseEntity.ok(service.getCourseGrades(courseId));
  }

  @GetMapping("/students/{studentId}/courses/{courseId}")
  public ResponseEntity<GradeDto> getGrade(@PathVariable Long studentId,
      @PathVariable Long courseId) {
    return ResponseEntity.ok(service.getGrade(studentId, courseId));
  }

  @PostMapping("/students/{studentId}/courses/{courseId}")
  public ResponseEntity<GradeDto> saveGrade(@RequestBody @Valid Grade grade,
      @PathVariable Long studentId,
      @PathVariable Long courseId) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(service.saveGrade(grade, studentId, courseId));
  }

  @PutMapping("/students/{studentId}/courses/{courseId}")
  public ResponseEntity<GradeDto> updateGrade(@RequestBody Grade grade,
      @PathVariable Long studentId,
      @PathVariable Long courseId) {
    return ResponseEntity.ok(service.updateGrade(grade, studentId, courseId));
  }

  @DeleteMapping("/students/{studentId}/courses/{courseId}")
  public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId,
      @PathVariable Long courseId) {
    service.deleteGrade(studentId, courseId);
    return ResponseEntity.noContent().build();
  }

}
