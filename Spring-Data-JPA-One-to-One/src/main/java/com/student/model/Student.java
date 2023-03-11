package com.student.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_sequence",initialValue = 1,allocationSize = 1)
    private int id;
    private String name;
    private String department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Student(String name, String department, Address address) {
        this.name = name;
        this.department = department;
        this.address = address;
    }
}
