package dev.kush.onetoone.controller;

import dev.kush.onetoone.dto.AssignLaptopDto;
import dev.kush.onetoone.exception.ResponseDto;
import dev.kush.onetoone.model.Student;
import dev.kush.onetoone.dto.StudentDto;
import dev.kush.onetoone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/get/{studentId}")
    public ResponseDto getStudentById(@PathVariable Long studentId) {

        return studentService.getStudentById(studentId);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentId, studentDto);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long studentId) {
        return studentService.deleteStudentById(studentId);
    }

    @PostMapping("assign")
    public ResponseEntity<Student> assignLaptop(@RequestBody AssignLaptopDto assignLaptopDto) {
        return studentService.assignLaptop(assignLaptopDto);
    }
}
