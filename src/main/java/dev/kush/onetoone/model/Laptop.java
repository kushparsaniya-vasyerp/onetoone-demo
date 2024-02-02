package dev.kush.onetoone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Laptop {

    @Id  @GeneratedValue
    @JsonIgnore
    private Long laptopId;
    private String laptopBrand;
    private String ram;
    private String cpu;
    private String price;

    public Laptop(String laptopBrand, String ram, String cpu, String price) {
        this.laptopBrand = laptopBrand;
        this.ram = ram;
        this.cpu = cpu;
        this.price = price;
    }
}
