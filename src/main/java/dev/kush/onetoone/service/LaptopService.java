package dev.kush.onetoone.service;

import dev.kush.onetoone.model.Laptop;
import dev.kush.onetoone.model.LaptopDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopService {

    ResponseEntity<List<Laptop>> getAllLaptops();

    ResponseEntity<Laptop> getLaptopById(Long id);

    ResponseEntity<Laptop> saveLaptop(LaptopDto laptopDto);




}
