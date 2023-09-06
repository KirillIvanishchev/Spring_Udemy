package com.aspectorientatedprogramming.demo.dao;

import com.aspectorientatedprogramming.demo.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String login;

    private String password;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account accountImpl, boolean VIP) {
        System.out.println(getClass() + ": DOING MY DATABASE WORK, adding an ACCOUNT");
    }

    @Override
    public List<Account>  findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException();
        }
        List<Account> result = new ArrayList<>();
        result.add(new Account("acc1", "1"));
        result.add(new Account("acc2", "2"));
        result.add(new Account("acc3", "3"));
        return result;
    }

    @Override
    public boolean doWork() {
        return true;
    }

    public String getLogin() {
        System.out.println("getLogin " + getClass());
        return login;
    }

    public void setLogin(String login) {
        System.out.println("setLogin " + getClass());
        this.login = login;
    }

    public String getPassword() {
        System.out.println("getPassword " + getClass());
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword " + getClass());
        this.password = password;
    }
}
