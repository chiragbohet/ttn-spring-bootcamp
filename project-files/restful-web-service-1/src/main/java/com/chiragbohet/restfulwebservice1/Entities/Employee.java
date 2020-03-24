package com.chiragbohet.restfulwebservice1.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter @Setter @AllArgsConstructor
public class Employee {

    Integer id;

    @Size(min=2, message = "Required atleast 2 characters in the name!")
    String name;

    @Min(value = 18,message = "Age should be >= 18")
    Integer age;
}
