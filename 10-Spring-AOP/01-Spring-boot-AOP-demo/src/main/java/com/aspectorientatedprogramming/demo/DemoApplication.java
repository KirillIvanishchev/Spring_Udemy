package com.aspectorientatedprogramming.demo;

import com.aspectorientatedprogramming.demo.dao.AccountDAO;
import com.aspectorientatedprogramming.demo.dao.MembershipDAO;
import com.aspectorientatedprogramming.demo.entities.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(String args[], AccountDAO accDAO, MembershipDAO memDAO) {
		return runner -> {
			demoBeforeAdvice(accDAO, memDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accDAO, MembershipDAO memDAO) {
		Account account = null;
		accDAO.addAccount(account, true);
		System.out.println(accDAO.doWork());
		memDAO.addMembership();
		memDAO.goToSleep();
	}
}
