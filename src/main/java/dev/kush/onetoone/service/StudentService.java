package dev.kush.onetoone.service;


import dev.kush.onetoone.model.AssignLaptopDto;
import dev.kush.onetoone.model.Student;
import dev.kush.onetoone.model.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<List<Student>> getAllStudent();

    ResponseEntity<Student> getStudentById(Long id);

    ResponseEntity<Student> saveStudent(StudentDto studentDto);

    ResponseEntity<Student> updateStudent(Long id,StudentDto studentDto);

    ResponseEntity<String> deleteStudentById(Long id);

    ResponseEntity<Student> assignLaptop(AssignLaptopDto assignLaptopDto);


}
