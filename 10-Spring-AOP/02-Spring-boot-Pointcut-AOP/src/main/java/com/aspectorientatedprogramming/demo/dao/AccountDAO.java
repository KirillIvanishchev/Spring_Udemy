package com.aspectorientatedprogramming.demo.dao;

import com.aspectorientatedprogramming.demo.entities.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();
    void addAccount(Account account, boolean VIP);

    List<Account>  findAccounts(boolean tripWire);

    boolean doWork();

     String getLogin();

     void setLogin(String login);

     String getPassword();
     void setPassword(String password);
}
