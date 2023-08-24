package com.demoproject.advancedmapping.DAO;

import com.demoproject.advancedmapping.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AppDAOImpl implements AppDAO{

    EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(User theUser) {
        entityManager.persist(theUser);
    }

    @Override
    public User findUserById(Long id) {
        System.out.println("finding user by id: " + id);
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public String deleteUserById(Long id) {
        System.out.println("deleting User by id: " + id);
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return "Deleted user: " + user;
    }
}
