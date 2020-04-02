package com.chiragbohet.springdatajpahibernate3.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @ManyToMany(mappedBy = "subjects" )
    List<Author> authors;

}
