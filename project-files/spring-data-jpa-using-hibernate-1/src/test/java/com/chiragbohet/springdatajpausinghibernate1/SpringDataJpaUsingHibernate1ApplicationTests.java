package com.chiragbohet.springdatajpausinghibernate1;

import com.chiragbohet.springdatajpausinghibernate1.Entity.Employee;
import com.chiragbohet.springdatajpausinghibernate1.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaUsingHibernate1ApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void addsDummyData(){
		for(int i = 0; i < 50; i++){
			Employee dummy = new Employee();
			dummy.setAge(0);
			dummy.setLocation("nowhere");
			dummy.setName("dummy");
			employeeRepository.save(dummy);
		}
	}

}
