package com.myapp.RESTful.service;

import com.myapp.RESTful.entity.Employee;
import com.myapp.RESTful.repository.EmployeeDAO_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service
@Service
public class EmployeeServiceImpl implements BaseService<Employee> {

    private EmployeeDAO_Repository employeeDAORepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO_Repository employeeDAORepository) {
        this.employeeDAORepository = employeeDAORepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAORepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAORepository.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee entity) {
        return employeeDAORepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAORepository.deleteById(id);
    }
}
