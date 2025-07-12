package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.dto.StudentDto;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.EntityAlreadyExistException;
import com.ltp.gradesubmission.exception.EntityDoesNotExistException;
import com.ltp.gradesubmission.mapper.StudentMapper;
import com.ltp.gradesubmission.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository repository;

  @Override
  public Student getStudent(Long id) {
    return repository.findById(id).orElseThrow(
        () -> new EntityDoesNotExistException("Student", id));
  }

  @Override
  public Student saveStudent(StudentDto dto) {
    repository.findByNameAndBirthDate(dto.getName(), dto.getBirthDate())
        .ifPresent(s -> {
          throw new EntityAlreadyExistException(s.getName(), s.getBirthDate());
        });
    return repository.save(StudentMapper.dtoToStudent(dto));
  }

  @Override
  public void deleteStudent(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<Student> getStudents() {
    return repository.findAll();
  }

}
