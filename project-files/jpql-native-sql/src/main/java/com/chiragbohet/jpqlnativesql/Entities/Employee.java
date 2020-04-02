package com.chiragbohet.jpqlnativesql.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString
@Table(name = "employeeTable")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="empId")
    int id;

    @Column(name = "empFirstName")
    String firstName;

    @Column(name = "empLastName")
    String lastName;

    @Column(name = "empSalary")
    BigDecimal salary;

    @Column(name = "empAge")
    int age;

}
