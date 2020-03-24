package com.chiragbohet.restfulwebservice1.Controllers;

import com.chiragbohet.restfulwebservice1.DAOs.EmployeeDaoService;
import com.chiragbohet.restfulwebservice1.Entities.Employee;
import com.chiragbohet.restfulwebservice1.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDaoService employeeDaoService;

    //Q3. Implement GET http request for Employee to get list of employees.
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDaoService.retrieveAllEmployees();
    }

    //Q4. Implement GET http request using path variable top get one employee
    @GetMapping("/employees/{id}")
    public Employee getEmployeeWithId(@PathVariable int id) {
        Employee requestedEmployee = employeeDaoService.retrieveEmployeeById(id);

        if (requestedEmployee != null)
            return requestedEmployee;
        else
            throw new UserNotFoundException("No Employee found with id : " + id);
    }

    //Q5. Implement POST http request for Employee to create a new employee.
    //Q9. Apply validation while create a new employee using POST http Request.
    @PostMapping("/employees")
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        employeeDaoService.addEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //Q7. Implement DELETE http request for Employee to delete employee
    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployeeWithId(@PathVariable int id) {
        Employee deletedEmployee = employeeDaoService.deleteEmployeeById(id);

        if (deletedEmployee != null)
            return deletedEmployee;
        else
            throw new UserNotFoundException("No Employee found with id : " + id);
    }

    //Q8. Implement PUT http request for Employee to update employee
    @PutMapping("/employees")
    public Employee editOrCreateEmployee(@RequestBody Employee requestedEmployee) {
        return employeeDaoService.createEmployeeIfNotPresentElseUpdate(requestedEmployee);
    }

}
