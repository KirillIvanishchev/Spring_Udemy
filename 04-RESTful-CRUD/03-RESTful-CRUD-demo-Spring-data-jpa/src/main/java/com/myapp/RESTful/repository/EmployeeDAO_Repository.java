package com.myapp.RESTful.repository;

import com.myapp.RESTful.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//Fourth create an exact repositories for our data exchange.
// Implementing our "behaviour" for Database-Object relations through BaseRepository interface.
// Use @Repository annotation to create an exact repository for our data exchange.
@Repository
public class EmployeeDAO_Repository implements DataAccessObject_BaseRepository<Employee> {

    private EntityManager entityManager;

    //We need to use Autowired for EntityManager, because it is a BEAN, that is created automatically by Spring.
    @Autowired
    public EmployeeDAO_Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee foundEmployee = entityManager.find(Employee.class, id);
        return foundEmployee;
    }

    @Override
    public Employee save(Employee entity) {
        Employee savedEmployee = entityManager.merge(entity);
        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee foundEmployee = findById(id);
        entityManager.remove(foundEmployee);
    }
}
