package com.demoproject.advancedmapping.DAO;
import com.demoproject.advancedmapping.entities.User;

public interface AppDAO {
    void save(User theUser);

    User findUserById(Long id);

    String deleteUserById(Long id);
}
