package com.demoproject.advancedmapping.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_detail_id")
    private UserDetails userDetails;


    //We use fetch Type=EAGER here to get all the characters.
    //As default is used LAZY type, and that's why Exception can be thrown, and we cannot get all the characters.
    //Used in AdvancedMappingApplication.java, findUserWithCharacters().

    //If we want to use LAZY initialization, we need to define DAO implementation for additional request.
    //This example is in
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = {   CascadeType.MERGE,
                                                CascadeType.DETACH,
                                                CascadeType.PERSIST,
                                                CascadeType.REFRESH })
    List<Character> characters;
    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addCharacter(Character character) {
        if (characters == null) {
            characters = new LinkedList<>();
        }
        characters.add(character);
        character.setUser(this);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }
}
