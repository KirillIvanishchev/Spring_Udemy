package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAllWithoutSorting();

	List<Employee> findAllByOrderByLastNameAsc();

	Employee findById(int theId);

	void save(Employee theEmployee);

	void deleteById(int theId);
}
