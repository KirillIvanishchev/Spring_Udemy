package com.aspectorientatedprogramming.demo.dao;

import com.aspectorientatedprogramming.demo.entities.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean VIP);

    boolean doWork();
}
