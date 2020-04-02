package com.chiragbohet.jpqlnativesql;

import com.chiragbohet.jpqlnativesql.Entities.Employee;
import com.chiragbohet.jpqlnativesql.Repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpqlNativeSqlApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	void utilityPrintAllEntries(){
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		employees.forEach(e-> System.out.println(e));
	}


	@Test
	void createEmployee(){

		Employee employee = new Employee();
		employee.setFirstName("Ravinder");
		employee.setLastName("Singh");
		employee.setAge(50);
		employee.setSalary(new BigDecimal("30000"));

		employeeRepository.save(employee);
	}

	@Test
	void test_Q4(){

		List<Object[]> partialData = employeeRepository.Q4_findLastNameEndingInSingh();

		partialData.forEach(e->{

			for(Object entry : e)
			{
				System.out.println(entry);
			}

		});
	}

	@Test
	@Transactional
	void test_Q5(){
		utilityPrintAllEntries();
		employeeRepository.Q5_deleteAllWithAgeGreaterThan(45);
		System.out.println("---------------------------------DELETED--------------------------------");
		utilityPrintAllEntries();
	}


	@Test
	void test_Q1(){
		List<Object[]> partialData = employeeRepository.Q1_findFirstLastName();

		partialData.forEach(e->{

			for(Object entry : e)
			{
				System.out.println(entry);
			}

		});
	}
}
