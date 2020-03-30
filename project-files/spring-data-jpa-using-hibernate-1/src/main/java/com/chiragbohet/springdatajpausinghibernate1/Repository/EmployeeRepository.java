package com.chiragbohet.springdatajpausinghibernate1.Repository;

import com.chiragbohet.springdatajpausinghibernate1.Entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>
{
    List<Employee> findAllByName(String name);
    List<Employee> findAllByNameLike(String wildcard);
    List<Employee> findAllByAgeBetween(int low, int high);

}
