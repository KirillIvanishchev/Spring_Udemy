package com.demoproject.advancedmapping;

import com.demoproject.advancedmapping.DAO.AppDAO;
import com.demoproject.advancedmapping.entities.User;
import com.demoproject.advancedmapping.entities.UserDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			//deleteUserById(appDAO, 4L);
			//findUserDetailsById(appDAO, 1L);
			deleteUserDetailsById(appDAO, 6L);
		};
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
