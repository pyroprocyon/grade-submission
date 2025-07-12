package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.exception.EntityAlreadyExistException;
import com.ltp.gradesubmission.exception.EntityDoesNotExistException;
import com.ltp.gradesubmission.repository.CourseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository repository;

  @Override
  public Course getCourse(Long id) {
    return repository.findById(id).orElseThrow(
        () -> new EntityDoesNotExistException("Course", id)
    );
  }

  @Override
  public Course saveCourse(Course course) {
    repository.findBySubjectAndCode(course.getSubject(), course.getCode()).ifPresent(
        c -> {
          throw new EntityAlreadyExistException(c.getSubject(), c.getCode());
        }
    );
    return repository.save(course);
  }

  @Override
  public void deleteCourse(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<Course> getCourses() {
    return repository.findAll();
  }

}
