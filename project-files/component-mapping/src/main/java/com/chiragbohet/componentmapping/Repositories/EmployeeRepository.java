package com.chiragbohet.componentmapping.Repositories;

import com.chiragbohet.componentmapping.Entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
