package com.chiragbohet.springdatajpahibernate3.Repositories;

import com.chiragbohet.springdatajpahibernate3.Entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {}
