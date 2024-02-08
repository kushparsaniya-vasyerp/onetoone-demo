package dev.kush.onetoone.service;


import dev.kush.onetoone.dto.AssignLaptopDto;
import dev.kush.onetoone.exception.ResponseDto;
import dev.kush.onetoone.model.Student;
import dev.kush.onetoone.dto.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<List<Student>> getAllStudent();

    ResponseDto getStudentById(Long id);

    ResponseEntity<Student> saveStudent(StudentDto studentDto);

    ResponseEntity<Student> updateStudent(Long id,StudentDto studentDto);

    ResponseEntity<String> deleteStudentById(Long id);

    ResponseEntity<Student> assignLaptop(AssignLaptopDto assignLaptopDto);


}
