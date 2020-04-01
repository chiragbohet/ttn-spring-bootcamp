package com.chiragbohet.springdatajpausinghibernate1.Controller;

import com.chiragbohet.springdatajpausinghibernate1.DAO.EmployeeDao;
import com.chiragbohet.springdatajpausinghibernate1.Entity.Employee;
import com.chiragbohet.springdatajpausinghibernate1.Exceptions.UserNotFoundException;
import com.chiragbohet.springdatajpausinghibernate1.Repository.EmployeeRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

//    @GetMapping("/employees")
//    List<Employee> getAllEmployees(){
//        return (List<Employee>) employeeRepository.findAll();
//    }

    @GetMapping("/employees")
    ResponseEntity getAllEmployees(@RequestParam(value = "page", defaultValue = "0") Optional<Integer> page,
                                   @RequestParam(value = "size", defaultValue = "20") Optional<Integer> size,
                                   @RequestParam(value = "sort", defaultValue = "id") Optional<String> sortProperty,
                                   @RequestParam(value = "direction", defaultValue = "asc") Optional<String> sortDirection) {

        Sort.Direction sortingDirection = sortDirection.get().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(page.get(), size.get(), sortingDirection, sortProperty.get()));

        //Adding X-TOTAL-COUNT header representing total count of Employees
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("X-TOTAL-COUNT", Arrays.asList(String.valueOf(employeeRepository.count())));

        return new ResponseEntity<>(employees, headers, HttpStatus.OK);

    }

    //Q3. Perform Create Operation on Entity using Spring Data JPA
    @PostMapping("/employees")
    ResponseEntity createEmployee(@RequestBody Employee employee) {

        Employee createdEmployee = employeeRepository.save(employee);

        if (createdEmployee == null) {
            // something went wrong and data cannot be saved
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdEmployee.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
    }

    @DeleteMapping("/employees/{id}")
    Employee deleteEmployee(@PathVariable int id) {
        Optional<Employee> employeeToDelete = employeeRepository.findById(id);

        if (employeeToDelete.isPresent())
        {
            employeeRepository.delete(employeeToDelete.get());
            return employeeToDelete.get();
        }
            else
            throw new UserNotFoundException("No user found with id : " + id);
    }


    @GetMapping("/employees/search")
    List<Employee> temporaryCustomSearch(@RequestParam("name") Optional<String> name,
                                         @RequestParam("nameLike") Optional<String> wildcard,
                                         @RequestParam("ageLow") Optional<Integer> low ,
                                         @RequestParam("ageHigh") Optional<Integer> high) {

        if (name.isPresent())
            return employeeRepository.findAllByName(name.get());
        else if (wildcard.isPresent())
            return employeeRepository.findAllByNameLike(wildcard.get());
        else if (low.isPresent() && high.isPresent())
            return employeeRepository.findAllByAgeBetween(low.get(), high.get());
        else
            return null;

    }

}
