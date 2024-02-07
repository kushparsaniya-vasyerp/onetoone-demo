package dev.kush.onetoone.service.impl;

import dev.kush.onetoone.exception.UserNotFoundException;
import dev.kush.onetoone.dto.AssignLaptopDto;
import dev.kush.onetoone.model.Laptop;
import dev.kush.onetoone.model.Student;
import dev.kush.onetoone.dto.StudentDto;
import dev.kush.onetoone.repository.LaptopRepository;
import dev.kush.onetoone.repository.StudentRepository;
import dev.kush.onetoone.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;

    @Autowired

    public StudentServiceImpl(StudentRepository studentRepository, LaptopRepository laptopRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentRepository.findAll(), OK);
    }

    @Override
    public ResponseEntity<Student> getStudentById(Long id) {
        return new ResponseEntity<>(findStudentById(id), OK);
    }


    @Override
    public ResponseEntity<Student> saveStudent(StudentDto studentDto) {
        final Student student = studentRepository.save(
                modelMapper.map(studentDto, Student.class));

        return new ResponseEntity<>(student, OK);
    }

    @Override
    public ResponseEntity<Student> updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = findStudentById(id);

        if (studentDto.getStudentEmail() != null && !studentDto.getStudentEmail().isEmpty()) {
            existingStudent.setStudentEmail(studentDto.getStudentEmail());
        }

        if (studentDto.getStudentName()!= null &&!studentDto.getStudentName().isEmpty()) {
            existingStudent.setStudentName(studentDto.getStudentName());
        }

        if (studentDto.getStudentPhone()!= null &&!studentDto.getStudentPhone().isEmpty()) {
            existingStudent.setStudentPhone(studentDto.getStudentPhone());
        }

        return new ResponseEntity<>(studentRepository.save(existingStudent),OK);
    }

    @Override
    public ResponseEntity<String> deleteStudentById(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new UserNotFoundException("student with id " + id + " not found");
        }
        studentRepository.deleteById(id);
        return new ResponseEntity<>("successfully deleted",NOT_FOUND);
    }

    @Override
    public ResponseEntity<Student> assignLaptop(AssignLaptopDto assignLaptopDto) {

        Laptop existingLaptop = laptopRepository.findById(assignLaptopDto.laptopId()).orElseThrow(
                () -> new UserNotFoundException("laptop with id " + assignLaptopDto.laptopId() + " not found")
        );

        Student existingStudent = findStudentById(assignLaptopDto.studentId());

        existingStudent.setLaptop(existingLaptop);
        return new ResponseEntity<>(studentRepository.save(existingStudent),OK);

    }


    private Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("student with id " + id + " not found"));
    }
}
