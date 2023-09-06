package com.aspectorientatedprogramming.demo;

import com.aspectorientatedprogramming.demo.dao.AccountDAO;
import com.aspectorientatedprogramming.demo.dao.MembershipDAO;
import com.aspectorientatedprogramming.demo.entities.Account;
import com.aspectorientatedprogramming.demo.service.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(String args[], AccountDAO accDAO,
									MembershipDAO memDAO,
									DemoService demoService) {
		return runner -> {
			//demoBeforeAdvice(accDAO, memDAO);
			//demoAfterReturningAdvice(accDAO);
			//demoAfterThrowingAdvice(accDAO);
			demoAroundAdvice(demoService);
			demoAroundAdviceHandleException(demoService);
		};
	}

	private void demoAroundAdviceHandleException(DemoService demoService) {
		System.out.println("\n\n Main program: calling AroundAdvice method.");
		boolean tripWire = true;
		String data = demoService.getService(tripWire);

		System.out.println(data);
	}

	private void demoAroundAdvice(DemoService demoService) {
		System.out.println("\n\n Main program: calling AroundAdvice method.");
		String data = demoService.getService();

		System.out.println(data);
	}

	private void demoAfterThrowingAdvice(AccountDAO accDAO) {
		List<Account> accounts = null;
		try {
			boolean tripWire = false;
			accDAO.findAccounts(tripWire);
			System.out.println("\n\n" +
					"Accounts found in Main method: demoAfterReturningAdvice(): " + accounts);
		}
		catch (Exception e) {
			System.out.println("\n\n Cought exception in Main method: demoAfterReturningAdvice(): " + e);
		}
	}

	private void demoAfterReturningAdvice(AccountDAO accDAO) {
		List<Account> accounts = accDAO.findAccounts();
		System.out.println("\n\n" +
				"Accounts found in Main method: demoAfterReturningAdvice(): " + accounts);
	}

	private void demoBeforeAdvice(AccountDAO accDAO, MembershipDAO memDAO) {
		Account account = new Account("login", "password");
		accDAO.addAccount(account, true);
		System.out.println(accDAO.doWork());

		accDAO.setLogin("login");
		accDAO.setPassword("password");

		String login = accDAO.getLogin();
		String password = accDAO.getPassword();

		memDAO.addMembership();
		memDAO.goToSleep();
	}
}
