package dev.kush.onetoone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto{
        private String studentName;
        private String studentEmail;
        private String studentPhone;
        private Laptop laptop;

}
