package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Course;
import java.util.List;
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
@RequestMapping("/courses")
public class CourseController {

  @GetMapping
  public ResponseEntity<List<Course>> getCourses() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Course> getCourse(@PathVariable Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
    return new ResponseEntity<>(course, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
