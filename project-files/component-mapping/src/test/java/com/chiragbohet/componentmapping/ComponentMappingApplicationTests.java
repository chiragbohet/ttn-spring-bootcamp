package com.chiragbohet.componentmapping;

import com.chiragbohet.componentmapping.Entities.Employee;
import com.chiragbohet.componentmapping.Entities.Salary;
import com.chiragbohet.componentmapping.Repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ComponentMappingApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate(){
		Employee employee = new Employee();
		employee.setFirstName("Chirag");
		employee.setLastName("Bohet");
		employee.setAge(24);

		Salary salary = new Salary();
		salary.setBasicSalary(new BigDecimal("10000"));
		salary.setBonusSalary(new BigDecimal("3000"));
		salary.setSpecialAllowanceSalary(new BigDecimal("20000"));
		salary.setTaxAmount(new BigDecimal("0"));

		employee.setSalary(salary);

		employeeRepository.save(employee);
	}


}
