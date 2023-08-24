package com.demoproject.advancedmapping.DAO;
import com.demoproject.advancedmapping.entities.User;
import com.demoproject.advancedmapping.entities.UserDetails;

public interface AppDAO {
    void save(User theUser);

    User findUserById(Long id);

    void deleteUserById(Long id);

    UserDetails findUserDetailsById(Long id);

    void deleteUserDetailsById(Long id);
}
