package com.demoproject.advancedmapping.DAO;

import com.demoproject.advancedmapping.entities.Character;
import com.demoproject.advancedmapping.entities.Item;
import com.demoproject.advancedmapping.entities.User;
import com.demoproject.advancedmapping.entities.AccountDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void deleteUserById(Long id) {
        System.out.println("deleting User by id: " + id);
        User user = entityManager.find(User.class, id);
        List<Character> listOfCharacters = user.getCharacters();
        for (Character character : listOfCharacters) {
            character.setUser(null);
        }
        entityManager.remove(user);
        System.out.println("Deleted user: " + user);
    }

    @Override
    public AccountDetails findUserDetailsById(Long id) {
        System.out.println("finding user details by id: " + id);
        AccountDetails details = entityManager.find(AccountDetails.class, id);
        System.out.println("User details: " + details);
        return details;
    }

    @Override
    @Transactional
    public void deleteUserDetailsById(Long id) {
        System.out.println("Deleting user details by ID: " + id);
        AccountDetails details = entityManager.find(AccountDetails.class, id);

        //TO delete ONLY user details, we need to break bi-directional relationships.
        //So, basically set the user details to null
        details.getUser().setUserDetails(null);

        System.out.println("Deleting user details: " + details);
        entityManager.remove(details);
    }

    @Override
    public List<Character> findCharactersByUserId(Long id) {
        TypedQuery<Character> query = entityManager.createQuery("FROM Character where user.id = :userId", Character.class);
        query.setParameter("userId", id);
        return query.getResultList();
    }

    @Override
    public User findUserByJoinFetch(Long id) {
        TypedQuery<User> query = entityManager.createQuery(
                                "SELECT key FROM User key " +
                                "JOIN FETCH key.characters " +
                                "JOIN FETCH key.userDetails " +
                                "WHERE key.id = :data", User.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public Character findCharacterById(Long id) {
        return entityManager.find(Character.class, id);
    }

    @Override
    @Transactional
    public void updateCharacter(Character character) {
        entityManager.merge(character);
    }

    @Override
    @Transactional
    public void deleteCharacterById(Long id) {
        Character character = findCharacterById(id);
        entityManager.remove(character);
    }

    @Override
    @Transactional
    public void saveItem(Item item) {
        entityManager.persist(item);
    }

    @Override
    @Transactional
    public void saveCharacter(Character character) {
        entityManager.persist(character);
    }

    @Override
    public Character findCharacterAndItemsById(Long id) {
        TypedQuery<Character> query = entityManager.createQuery(
                            "SELECT key FROM Character key " +
                            "JOIN FETCH key.items " +
                            "WHERE key.id = :data", Character.class);
        query.setParameter("data", id);
        Character character = query.getSingleResult();
        return character;
    }

    @Override
    @Transactional
    public void deleteCharacterAndItemsById(Long id) {
        entityManager.remove(findCharacterAndItemsById(id));
    }

    @Override
    public void deleteCharacterWithoutJoinFetch(Long id) {

    }

    @Override
    public Character findCharacterAndCharacterClassesByCharacterId(Long id) {
        TypedQuery<Character> query = entityManager.createQuery(
                "SELECT key FROM Character key " +
                "JOIN FETCH key.characterClasses " +
                "WHERE key.id = :data", Character.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }
}
