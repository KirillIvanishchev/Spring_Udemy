package com.myapp.hibernatejpaCRUDdemo.dao;

import com.myapp.hibernatejpaCRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//This is Data Access Object, or DAO Repository.
//DAOs are made to manage Transactions from Database to java classes.
//To create DAO need to create interface, class with interface implementation.
//Class need to annotate with @Repository.
//If it will be some UPDATES, like storing or saving objects, method, will be annotated with @Transactional.
@Repository
public class StudentDAOImplementation implements BasicDAO<Student> {
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //If it will be some UPDATES, like storing or saving objects in DataBase, method will be annotated with @Transactional.

    @Override
    @Transactional
    public void save(Student student) {
        //For saving java objects as Enities, we need to use entityManager.persist method.
        //We are making some changes in the Database, we MUST use @Transactional annotation.
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void saveAll(List<Student> list) {
        //For saving multiple objects we need to use loop for List of objects.
        //We are making some changes in the Database, we MUST use @Transactional annotation.
        for (Student student : list) {entityManager.persist(student);}
    }

    @Override
    public Student findById(Integer id) {
        //We don't make any changes in the Database, we just need to find object in the Database.
        //We don't need to use @Transactional annotation.
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //to find multiple objects, need to use JPQL query;
        //JPQL is the short language, very similar to SQL.
        //Also, there is a specific TypedQuery object, which is used for JPQL.

        //VERY IMPORTANT Student from "FROM Student" query is name of java Entity (Class), not the table name.

        //Here we can also sort objects by parameters. In this case by lastName (REMEMBER! this is java field (Entity)).
        //To sort parameters in A-Z order, we need to use ASC, in other case Z-A order, we need to use DESC.
        TypedQuery<Student> entityQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        //As result, need to return List<Student>, so getResultList() method is used.
        return entityQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //Method to find objects by lastName. Similar to findAll() method, but other query.
        //VERY IMPORTANT! :JPQL_parameter is a JPQL parameter, that is used further.
        //All JPQL parameters can have different names, but in a such queries MUST have : before them.
        TypedQuery<Student> entityQuery = entityManager.createQuery("FROM Student WHERE lastName = :JPQL_parameter", Student.class);

        //To set JPQL parameter, we need to use setParameter() method.
        //We need to define parameter theData using another method, setParameter().
        entityQuery.setParameter("JPQL_parameter", lastName);
        return entityQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        //Update is a method, which is used to update entities/ objects in Database.
        //We are making some changes in the Database, we MUST use @Transactional annotation.
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int NumberOfDeletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE Student").executeUpdate();
        return NumberOfDeletedRows;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        //Delete is a method, which is used to delete entities/ objects from Database.
        //We are making some changes in the Database, we MUST use @Transactional annotation.
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteByFirstName(String keyWord) {
        //Delete is a method, which is used to delete entities/ objects from Database.
        //We are making some changes in the Database, we MUST use @Transactional annotation.
        //VERY IMPORTANT! :JPQL_parameter is a JPQL parameter, that is used further.
        //All JPQL parameters can have different names, but in a such queries MUST have : before them.
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student WHERE firstName = :JPQL_parameter", Student.class)
                .setParameter("JPQL_parameter", keyWord)
                .executeUpdate();
        return numRowsDeleted;
    }
}
