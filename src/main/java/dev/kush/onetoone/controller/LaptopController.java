package dev.kush.onetoone.controller;

import dev.kush.onetoone.model.Laptop;
import dev.kush.onetoone.model.LaptopDto;
import dev.kush.onetoone.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Laptop>> getAllLaptop() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("get/{laptopId}")
    public ResponseEntity<Laptop> getLaptopByLaptopId(@PathVariable Long laptopId) {
        return laptopService.getLaptopById(laptopId);
    }

    @PostMapping("/add")
    public ResponseEntity<Laptop> addLaptop(@RequestBody LaptopDto laptopDto) {
        return laptopService.saveLaptop(laptopDto);
    }


}
