package com.chiragbohet.springdatajpahibernate3;

import com.chiragbohet.springdatajpahibernate3.Embeddable.Address;
import com.chiragbohet.springdatajpahibernate3.Entities.Author;
import com.chiragbohet.springdatajpahibernate3.Entities.Book;
import com.chiragbohet.springdatajpahibernate3.Entities.Subject;
import com.chiragbohet.springdatajpahibernate3.Repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringDataJpaHibernate3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void addTestData(){
		Author author = new Author();

		author.setName("J.K. Rowling");

		Address address = new Address();
		address.setStreetNumber(19);
		address.setLocation("London");
		address.setState("Cambridge");

		author.setAddress(address);

		Subject eng = new Subject();
		eng.setName("English");

		Subject fr = new Subject();
		fr.setName("French");

		Subject sw = new Subject();
		sw.setName("Swedish");

		List<Subject> subjects = Arrays.asList(eng,fr,sw);

		author.setSubjects(subjects);

		Book book = new Book();
		book.setName("Harry Potter and the Philosopher's Stone");

		Book book1 = new Book();
		book1.setName("Harry Potter and the Deathly Hallows");

		author.setBooks(book,book1);

		authorRepository.save(author);
	}



}
