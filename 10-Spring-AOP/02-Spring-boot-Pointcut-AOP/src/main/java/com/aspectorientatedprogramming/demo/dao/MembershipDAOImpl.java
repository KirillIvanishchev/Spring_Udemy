package com.aspectorientatedprogramming.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addMembership() {
        System.out.println(getClass() + ": DOING MY DATABASE WORK, adding an MEMBERSHIP");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("Im going to sleep");
    }
}
