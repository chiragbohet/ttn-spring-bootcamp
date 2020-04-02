package com.chiragbohet.componentmapping.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employeeTable")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    Integer id;

    @Column(name = "empFirstName")
    String firstName;

    @Column(name = "empLastName")
    String lastName;

    @Column(name = "empAge")
    Integer age;

    @Embedded
    Salary salary;

}
