package com.demoproject.advancedmapping.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "playable_character")
public class Character {
    public Character() {}

    public Character(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String name;

    @ManyToOne (cascade = { CascadeType.MERGE,
                            CascadeType.DETACH,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH })
    @JoinColumn(name = "user_id")
    User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
