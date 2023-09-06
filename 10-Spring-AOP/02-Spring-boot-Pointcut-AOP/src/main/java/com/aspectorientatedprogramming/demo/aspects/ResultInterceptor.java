package com.aspectorientatedprogramming.demo.aspects;

import com.aspectorientatedprogramming.demo.entities.Account;

import java.util.List;

public class ResultInterceptor {
    static void convertAccountsToUpperCase(List<Account> result)
    {
        System.out.println("@@@@@@@@@@@>>>> INTERCEPTOR Aspect triggered");
        for (Account account : result)
        {
            account.setLogin(account.getLogin().toUpperCase());
        }
    }
}
