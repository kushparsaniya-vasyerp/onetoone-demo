package dev.kush.onetoone.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id @GeneratedValue
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentPhone;

    @OneToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    public Student(String studentName, String studentEmail, String studentPhone, Laptop laptop) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.laptop = laptop;
    }

    public Student(String studentName, String studentEmail, String studentPhone) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
    }


}
