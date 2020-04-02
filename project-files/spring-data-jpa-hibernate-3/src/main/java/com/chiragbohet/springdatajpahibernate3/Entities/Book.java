package com.chiragbohet.springdatajpahibernate3.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

//    //OneToOne
//    @OneToOne(mappedBy = "book")
//    Author author;

//    // OneToMany Bidirectional
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    Author author;

    // ManyToMany
    @ManyToMany(mappedBy = "bookSet")
    Set<Author> authors;
}
