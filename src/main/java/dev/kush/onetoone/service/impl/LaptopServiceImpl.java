package dev.kush.onetoone.service.impl;

import dev.kush.onetoone.exception.UserNotFoundException;
import dev.kush.onetoone.model.Laptop;
import dev.kush.onetoone.model.LaptopDto;
import dev.kush.onetoone.repository.LaptopRepository;
import dev.kush.onetoone.service.LaptopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        return new ResponseEntity<>(laptopRepository.findAll(), OK);
    }

    @Override
    public ResponseEntity<Laptop> getLaptopById(Long id) {
        return new ResponseEntity<>(findLaptopByLaptopId(id), OK);
    }


    @Override
    public ResponseEntity<Laptop> saveLaptop(LaptopDto laptopDto) {
        Laptop laptop = laptopRepository.save(modelMapper.map(laptopDto,Laptop.class));
        return new ResponseEntity<>(laptop,OK);
    }
    private Laptop findLaptopByLaptopId(Long id) {
        return laptopRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("laptop with id " + id + " not found."));
    }
}
