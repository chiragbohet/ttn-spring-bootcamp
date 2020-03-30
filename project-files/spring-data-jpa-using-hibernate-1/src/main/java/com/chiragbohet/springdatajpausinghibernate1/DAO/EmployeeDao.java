package com.chiragbohet.springdatajpausinghibernate1.DAO;

import com.chiragbohet.springdatajpausinghibernate1.Entity.Employee;
import com.chiragbohet.springdatajpausinghibernate1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

    @Autowired
    EmployeeRepository  employeeRepository;






}
