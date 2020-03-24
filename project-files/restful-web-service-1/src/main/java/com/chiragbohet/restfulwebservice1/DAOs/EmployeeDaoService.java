package com.chiragbohet.restfulwebservice1.DAOs;

import com.chiragbohet.restfulwebservice1.Entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {

    //Trying to mock DB behavior with a list
    static List<Employee> employees = new ArrayList<>();

    //Adding some Employee's to the employees list to simulate employees stored in a DB
    static {
        employees.add(new Employee(1, "Chirag", 24));
        employees.add(new Employee(2, "Ajay", 24));
        employees.add(new Employee(3, "Manish", 35));
        employees.add(new Employee(4, "Elon", 40));
    }

    /***
     * Returns list of all Employees, currently in the system.
     * @return List of Employees
     */
    public List<Employee> retrieveAllEmployees() {
        return employees;
    }

    /***
     * Finds and returns a single Employee Object with given id
     * @param id id of the Employee
     * @return
     *      Employee Object, if found with given id
     *      null otherwise
     */
    public Employee retrieveEmployeeById(int id) {
        for (Employee employee : employees)
            if (employee.getId() == id)
                return employee;
        return null;
    }

    /***
     * Adds a new Employee Object to the employees list
     * If id field is not set auto set's the id to current employees count + 1
     * @param employee  Employee Object to be added to the list
     * @return Original Employee Object given as input
     */
    public Employee addEmployee(Employee employee) {
        if (employee.getId() == null)
            employee.setId(employees.size() + 1);

        employees.add(employee);
        return employee;
    }

    /***
     * Deletes Employee with given Id from the employees list.
     * @param id Id of the Employee to be deleted.
     * @return
     *      Employee Object of the Employee which is removed from the list, if found and deleted
     *      null otherwise
     */
    public Employee deleteEmployeeById(int id) {
        if (id > 0) {
            Iterator<Employee> iterator = employees.iterator();

            while (iterator.hasNext()) {
                Employee employeeToDelete = iterator.next();
                if (employeeToDelete.getId() == id) {
                    iterator.remove();
                    return employeeToDelete;
                }
            }
        }

        return null;
    }

    /***
     * Updates Employee Object in the employee list if found one with
     * matching id as input employee Object
     * If not found, creates a new Employee Object
     * @param requestedEmployee the Employee needed to be created/updated
     * @return created/updated Employee
     */
    public Employee createEmployeeIfNotPresentElseUpdate(Employee requestedEmployee) {
        Employee storedEmployee = retrieveEmployeeById(requestedEmployee.getId());

        if (storedEmployee == null) // if not found, create one
            addEmployee(requestedEmployee);

        else // if already present, update
            employees.set(employees.indexOf(storedEmployee), requestedEmployee);

        return requestedEmployee;
    }

}
