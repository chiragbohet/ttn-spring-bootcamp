## Exercise : Spring Data JPA using Hibernate, Part 1


### Q1. Create an Employee Entity which contains following fields
    
- Name
- Id
- Age
- Location

[Employee](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Entity/Employee.java)

```java
@Entity
@Getter
@Setter
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer age;
    String location;

}
```

### Q2. Set up EmployeeRepository with Spring Data JPA

[EmployeeRepository](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Repository/EmployeeRepository.java)

```java
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}
```

### Q3. Perform Create Operation on Entity using Spring Data JPA

[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
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
````

### Q4. Perform Update Operation on Entity using Spring Data JPA

[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
```


### Q5. Perform Delete Operation on Entity using Spring Data JPA

[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
@DeleteMapping("/employees/{id}")
    Employee deleteEmployee(@PathVariable int id) {
        Optional<Employee> employeeToDelete = employeeRepository.findById(id);

        if (employeeToDelete.isPresent())
            return employeeToDelete.get();
        else
            throw new UserNotFoundException("No user found with id : " + id);
    }
```

### Q6. Perform Read Operation on Entity using Spring Data JPA

[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
@GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }
```

### Q7. Get the total count of the number of Employees

## I am returning total count of Employees as a response header ```X-TOTAL-COUNT```

[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
@GetMapping("/employees")
    ResponseEntity getAllEmployees(){

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();

        //Adding X-TOTAL-COUNT header representing total count of Employees
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("X-TOTAL-COUNT", Arrays.asList(String.valueOf(employees.size())));

        return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);

    }
```

Refrences :

- https://www.baeldung.com/spring-response-header

- https://stackoverflow.com/questions/3715981/what-s-the-best-restful-method-to-return-total-number-of-items-in-an-object

### Q8. Implement Pagination and Sorting on the bases of Employee Age

[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
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
```

### Q9. Create and use finder to find Employee by Name

### Q10. Create and use finder to find Employees starting with A character

### Q11. Create and use finder to find Employees Between the age of 28 to 32

### **Note : These 3 questions involve custom searching, after reading some articles on internet I found that searches should also be performed on the main resource URI i.e. on ```/employees``` and should be generic but all this requires more logic. For the time being I have created a single method which handles all 3 cases depending on request parameters supplied. It demonstrates use of custom finders decently.**


[EmployeeController](project-files/spring-data-jpa-using-hibernate-1/src/main/java/com/chiragbohet/springdatajpausinghibernate1/Controller/EmployeeController.java)

```java
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
```
