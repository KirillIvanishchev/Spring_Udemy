package com.demoproject.advancedmapping.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="account")
    private String account;


    @Column(name="description")
    private String description;

    public UserDetails() {}

    public UserDetails(String account, String description) {
        this.account = account;
        this.description = description;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
