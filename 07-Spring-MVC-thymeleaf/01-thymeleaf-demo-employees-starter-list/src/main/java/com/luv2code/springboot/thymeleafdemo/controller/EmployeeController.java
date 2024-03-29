package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String redirect() {
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        //get Employees from DB
        List<Employee> employeesList = employeeService.findAllByOrderByLastNameAsc();

        theModel.addAttribute("employees", employeesList);

        return "employees/list-employees";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model theModel) {
        Employee addedEmployee = new Employee();
        theModel.addAttribute("employee", addedEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/update-employee")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel) {
        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") int theId, Model theModel) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
}









