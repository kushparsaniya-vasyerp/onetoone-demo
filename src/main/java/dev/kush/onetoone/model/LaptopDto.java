package dev.kush.onetoone.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LaptopDto {
    private String laptopBrand;
    private String ram;
    private String cpu;
    private String price;

}