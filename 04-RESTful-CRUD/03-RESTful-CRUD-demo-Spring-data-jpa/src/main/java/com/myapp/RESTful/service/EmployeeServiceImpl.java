package com.myapp.RESTful.service;

import com.myapp.RESTful.dao.EmployeeRepository;
import com.myapp.RESTful.entity.Employee;
import com.myapp.RESTful.repository.EmployeeDAO_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service
@Service
public class EmployeeServiceImpl implements BaseService<Employee> {

    private EmployeeRepository employeeDAORepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAORepository) {
        this.employeeDAORepository = employeeDAORepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAORepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> byIdResult = employeeDAORepository.findById(id);
        Employee theEmployee;
        if (byIdResult.isPresent()) {
            theEmployee = byIdResult.get();
            return theEmployee;
        }
        else throw new RuntimeException("Employee not found: id [" + id + "]");
    }
    @Override
    public Employee save(Employee entity) {
        return employeeDAORepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
        employeeDAORepository.deleteById(id);
    }
}
