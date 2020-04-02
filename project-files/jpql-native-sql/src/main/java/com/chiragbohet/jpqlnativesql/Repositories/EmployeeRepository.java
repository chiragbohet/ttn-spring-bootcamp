package com.chiragbohet.jpqlnativesql.Repositories;

import com.chiragbohet.jpqlnativesql.Entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    //J P Q L

    //Q1. Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
    @Query("SELECT firstName, lastName FROM Employee WHERE salary > (SELECT AVG(salary) FROM Employee) ORDER BY age ASC, salary DESC")
    List<Object[]> Q1_findFirstLastName();

    // TODO Q2. Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
    // TODO Q3. Delete all employees with minimum salary.


    // Native SQL

    //Q4. Display the id, first name, age of all employees where last name ends with "singh"
    @Query(value = "SELECT empId, empFirstName, empAge FROM employeeTable WHERE empLastName LIKE '%singh'", nativeQuery = true)
    List<Object[]> Q4_findLastNameEndingInSingh();

    //Q5. Delete all employees with age greater than 45(Should be passed as a parameter)
    @Modifying
    @Query(value = "DELETE FROM employeeTable WHERE empAge > :inputAge", nativeQuery = true)
    void Q5_deleteAllWithAgeGreaterThan(@Param("inputAge") int age);

}
