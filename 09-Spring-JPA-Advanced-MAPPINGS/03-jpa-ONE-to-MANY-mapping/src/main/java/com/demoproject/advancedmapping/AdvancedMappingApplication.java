package com.demoproject.advancedmapping;

import com.demoproject.advancedmapping.DAO.AppDAO;
import com.demoproject.advancedmapping.entities.Character;
import com.demoproject.advancedmapping.entities.Item;
import com.demoproject.advancedmapping.entities.User;
import com.demoproject.advancedmapping.entities.UserDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {
			//createUser(appDAO);
			//findUserById(appDAO, 1L);
			//updateUser(appDAO, 3L);
			//deleteUserById(appDAO, 4L);
			//findUserDetailsById(appDAO, 1L);
			//deleteUserDetailsById(appDAO, 6L);
			//createUserWithCharacters(appDAO);
			//findUserWithCharacters(appDAO, 3L);
			//findCharactersForUser(appDAO, 3L);
			//findUserWithCharactersJoinFetch(appDAO, 3L);
			//updateCharacter(appDAO, 10L);
			//deleteUserByIdWithoutCharacters(appDAO, 4L);
			//deleteCharacterById(appDAO, 11L);
			//createCharacterAndItem(appDAO);
			//findCharacterWithItemsById(appDAO, 10L);
			//deleteCharacterWithItems(appDAO, 11L);
			deleteCharacterWithItemsTestWithoutSQL_FetchJoin(appDAO, 11L);
		};
	}

	private void deleteCharacterWithItemsTestWithoutSQL_FetchJoin(AppDAO appDAO, long l) {
		System.out.println("Deleting Character with Items by id: " + l);
		appDAO.deleteCharacterById(l);
		System.out.println("Done!");
	}


	private void deleteCharacterWithItems(AppDAO appDAO, long l) {
		System.out.println("Deleting Character with Items by id: " + l);
		appDAO.deleteCharacterAndItemsById(l);
		System.out.println("Done!");
	}

	private void findCharacterWithItemsById(AppDAO appDAO, long l) {
		System.out.println("Finding Character with Items by id: " + l);
		Character character = appDAO.findCharacterAndItemsById(l);
		System.out.println("Character: " + character);
		System.out.println("Items: " + character.getItems());
	}

	private void createCharacterAndItem(AppDAO appDAO) {
		System.out.println("Creating Character");
		Character character = new Character("LuciusHelios");
		character.addItem(new Item("CyberSword"));
		character.addItem(new Item("CyberKnife"));
		character.addItem(new Item("CyberGun"));
		System.out.println("Saving Character " + character + " items " + character.getItems());
		appDAO.saveCharacter(character);
	}

	private void deleteCharacterById(AppDAO appDAO, long l) {
		System.out.println("Deleting Character id: " + l);
		appDAO.deleteCharacterById(l);
	}

	private void deleteUserByIdWithoutCharacters(AppDAO appDAO, long id) {
		System.out.println("Finding User id: " + id);
		User user = appDAO.findUserById(id);
		System.out.println("User: " + user);
		System.out.println("Deleting User: " + user);
		appDAO.deleteUserById(id);
	}

	private void updateCharacter(AppDAO appDAO, long id) {
		System.out.println("Finding the Character with ID of :" + id);
		Character character = appDAO.findCharacterById(id);
		character.setName("TEST");
		appDAO.updateCharacter(character);
	}

	private void updateUser(AppDAO appDAO, long id) {
		System.out.println("Finding User id: " + id);
		User user = appDAO.findUserById(id);
		System.out.println("Updating User id: " + id);
		user.setLastName("TEST");
		appDAO.updateUser(user);
		System.out.println("Updated User: " + user);
	}

	private void findUserWithCharactersJoinFetch(AppDAO appDAO, long id) {
		System.out.println("Finding User id: " + id);
		System.out.println("Finding all connected INFO by JOIN FETCH");
		User user = appDAO.findUserByJoinFetch(id);
		System.out.println("User: " + user);
		System.out.println("User details: " + user.getUserDetails());
		System.out.println("Characters: " + user.getCharacters());
	}

	private void findCharactersForUser(AppDAO appDAO, long id) {
		System.out.println("Finding User id: " + id);
		User user = appDAO.findUserById(id);
		System.out.println("User: " + user);
		System.out.println("Finding Characters for User: " + user.getFirstName());
		List<Character> characters = appDAO.findCharactersByUserId(id);

		System.out.println("ASSOCIATE CHARACTERS");
		user.setCharacters(characters);
		System.out.println("Characters: " + user.getCharacters());
	}

	private void findUserWithCharacters(AppDAO appDAO, long id) {
		System.out.println("Finding User id: " + id);
		User user = appDAO.findUserById(id);
		System.out.println("User: " + user);
		System.out.println("Characters" + user.getCharacters());
	}

	private void createUserWithCharacters(AppDAO appDAO) {
		User user =
				new User("Kirill", "Ivanishchev", "k@example.com");

		UserDetails details =
				new UserDetails("http://www.kirillivanishchev.com", "kirill_description");
		user.setUserDetails(details);

		Character DarthDairond = new Character("DarthDairond");
		Character LuciusHelios = new Character("LuciusHelios");

		user.addCharacter(DarthDairond);
		user.addCharacter(LuciusHelios);

		System.out.println("Saving the user: " + user);

		//appDAO.save(user) will save ALL information in the database, that is linked with the user.
		//Because of CascadeType.PERSIST.
		appDAO.save(user);

		System.out.println("Done!");
	}

	private void deleteUserDetailsById(AppDAO appDAO, long id) {
		appDAO.deleteUserDetailsById(id);
	}

	private void findUserDetailsById(AppDAO appDAO, long id) {
		UserDetails details = appDAO.findUserDetailsById(id);
		System.out.println("Associated user: " + details.getUser());
	}

	private void deleteUserById(AppDAO appDAO, long id) {
		appDAO.deleteUserById(id);
	}

	private void findUserById(AppDAO appDAO, long id) {
		User user = null;
		try {
			user = appDAO.findUserById(id);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(user);
	}

	private void createUser(AppDAO appDAO) {
		User user =
				new User("Kirill", "Ivanishchev", "k@example.com");

		UserDetails details =
				new UserDetails("http://www.kirillivanishchev.com", "kirill_description");
		user.setUserDetails(details);

		System.out.println("Saving the user: " + user);

		appDAO.save(user);

		System.out.println("Done!");
	}
}
