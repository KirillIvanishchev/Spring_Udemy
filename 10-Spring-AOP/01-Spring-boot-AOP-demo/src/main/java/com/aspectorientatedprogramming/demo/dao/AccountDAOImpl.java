package com.aspectorientatedprogramming.demo.dao;

import com.aspectorientatedprogramming.demo.entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean VIP) {
        System.out.println(getClass() + ": DOING MY DATABASE WORK, adding an ACCOUNT");
    }

    @Override
    public boolean doWork() {
        return true;
    }
}
