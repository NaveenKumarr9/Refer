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
public class Address {

    @Id
    @GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_gen",sequenceName = "address_sequence",initialValue = 1,allocationSize = 1)
    private int addressId;
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
