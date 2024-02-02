package dev.kush.onetoone.config;

import dev.kush.onetoone.model.Laptop;
import dev.kush.onetoone.model.Student;
import dev.kush.onetoone.repository.LaptopRepository;
import dev.kush.onetoone.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleData {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, LaptopRepository laptopRepository){
        return args -> {

            Laptop laptop = new Laptop("hp","8GB","i5","50000");
            laptopRepository.save(laptop);

            Student student = new Student("Kush","kush@gmail.com","1234567889",laptop);
            studentRepository.save(student);
        };
    }
}
