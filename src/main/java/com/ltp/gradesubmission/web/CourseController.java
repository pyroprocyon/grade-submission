package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.service.CourseService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

  private final CourseService service;

  @GetMapping
  public ResponseEntity<List<Course>> getCourses() {
    return ResponseEntity.ok(service.getCourses());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Course> getCourse(@PathVariable Long id) {
    return ResponseEntity.ok(service.getCourse(id));
  }

  @PostMapping
  public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCourse(course));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
    service.deleteCourse(id);
    return ResponseEntity.noContent().build();
  }

}
