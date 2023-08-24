package com.myapp.RESTful.rest;

import com.myapp.RESTful.entity.Employee;
import com.myapp.RESTful.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//At a five, we have created RestController class.
// Rest controller is used to handle HTTP requests between Client (Web page) and Service (Database).
// Our Repository is needed to create a bound between Java layer and Database layer, and also to for a behaviour between them.
// Use @RestController annotation to create Rest controller.
//Use @RequestMapping annotation to create a RESTful API. (HTTP bound)
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    //Just shows a list of Employees.
    // We use @GetMapping annotation to TAKE an Information from Database and SHOW it.
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeServiceImpl.findAll();
    }

    //Just shows a single Employee.
    // We use @GetMapping annotation to TAKE an Information from Database and SHOW it.
    @GetMapping("/employees/{id}")
    //We commonly use @PathVariable annotation to get a parameter from URL string.
    public Employee getEmployeeById(@PathVariable int id) {
        Employee found = employeeServiceImpl.findById(id);
        if (found == null)
            throw new RuntimeException("Employee not found");
        return found;
    }

    //Adds a new Employee to Database.
    // We use @PostMapping annotation to POST Information to Database.
    //We use @RequestBody annotation to convert out JSON Object to Java Object and add it to Database.
    @PostMapping("/employees")
    //BUT for JSON Parameters we need to use @RequestBody annotation in arguments!!!!!!!!!!!!!!!!
    public Employee addNewEmployee(@RequestBody Employee JSONEmployee) {

        //Just for right parsing and autoID set ID to 0.
        JSONEmployee.setId(0);
        Employee dbEmployee = employeeServiceImpl.save(JSONEmployee);
        return dbEmployee;
    }

    //Updates an existing Employee in Database.
    // We use @PutMapping annotation to PUT Information to Database, basically to update our EXISTING Database Entity.
    // We also use @RequestBody annotation to convert our JSON Object to Java Object and update it within our Database.
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee JSONEmployee) {
        Employee dbEmployee = employeeServiceImpl.save(JSONEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee deletedEmployee = employeeServiceImpl.findById(id);
        if (deletedEmployee == null)
            throw new RuntimeException("Employee not found");
        employeeServiceImpl.deleteById(id);
        return "Employee deleted" + deletedEmployee;
    }
}
