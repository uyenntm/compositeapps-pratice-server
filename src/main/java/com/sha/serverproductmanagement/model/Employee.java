package com.sha.serverproductmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="supervisor")
    private String supervisor;
}
