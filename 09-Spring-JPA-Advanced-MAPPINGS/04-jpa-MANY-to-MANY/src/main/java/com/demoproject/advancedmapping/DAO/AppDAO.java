package com.demoproject.advancedmapping.DAO;
import com.demoproject.advancedmapping.entities.Character;
import com.demoproject.advancedmapping.entities.Item;
import com.demoproject.advancedmapping.entities.User;
import com.demoproject.advancedmapping.entities.AccountDetails;

import java.util.List;

public interface AppDAO {
    void save(User theUser);

    User findUserById(Long id);

    void deleteUserById(Long id);

    AccountDetails findUserDetailsById(Long id);

    void deleteUserDetailsById(Long id);

    List<Character> findCharactersByUserId(Long id);

    User findUserByJoinFetch(Long id);

    void updateUser(User user);

    Character findCharacterById(Long id);

    void updateCharacter(Character character);

    void deleteCharacterById(Long id);

    void saveItem(Item item);
    void saveCharacter(Character character);
    Character findCharacterAndItemsById(Long id);
    void deleteCharacterAndItemsById(Long id);
    void deleteCharacterWithoutJoinFetch(Long id);

    Character findCharacterAndCharacterClassesByCharacterId(Long id);
}
