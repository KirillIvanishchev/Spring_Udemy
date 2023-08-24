package com.myapp.RESTful.dao;

import com.myapp.RESTful.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Here we add extended Repository from JpaRepository. This is needed, because we can
// get all previous methods from JpaRepository OUT OF THE BOX.
// so we don't need to write them again, as it was in future version.
// We also don't need to use @Transactional annotation in our Services, because
// JpaRepository adds all required methods with @Transactional annotation.

@RepositoryRestResource(path="members")
//@RepositoryRestResource annotation is made to define PATH for REST API,
// as an Example here, we must use "/members" path, instead of "/employees".
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
