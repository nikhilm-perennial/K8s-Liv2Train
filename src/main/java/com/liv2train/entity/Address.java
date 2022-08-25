package com.liv2train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 20,max = 1500,message = "Enter detailed address")
    private String detailedAddress;

    private String city;

    private String state;

    @Column(unique = true)
    private String pincode;

}
