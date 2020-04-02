package com.chiragbohet.springdatajpahibernate3.Entities;

import com.chiragbohet.springdatajpahibernate3.Embeddable.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @Embedded
    Address address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Subject> subjects;

//    //OneToOne
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    Book book;

//    // OneToMany Unidirectional
//    @OneToMany(cascade = CascadeType.ALL)
//    Set<Book> bookSet;

//    // OneToMany Unidirectional, without extra table
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="author_id")
//    Set<Book> bookSet;

//    // OneToMany Bidirectional
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    Set<Book> bookSet;

    // ManyToMany
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Book> bookSet;

    public void setBooks(Book... book){
        if(book != null)
        {
            if(bookSet == null)
                bookSet = new HashSet<>();

            for(Book bookEntry : book)
                {
                    //bookEntry.setAuthor(this);
                    bookSet.add(bookEntry);
                }
        }
    }


}
