package com.demoproject.advancedmapping.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "playable_character_id")
    List<Item> items;

    @ManyToMany (fetch = FetchType.LAZY, cascade = { CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable (
            name = "playable_character-class",
            joinColumns = @JoinColumn (name = "playable_character_id"),
            inverseJoinColumns = @JoinColumn (name = "class_id")
    )
    List<CharacterClass> characterClasses;
    public void addItem(Item item) {
        if(items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void addCharacterClass(CharacterClass characterClass) {
        if(characterClasses == null) {
            characterClasses = new ArrayList<>();
        }
        characterClasses.add(characterClass);
    }

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

    public List<Item> getItems() {
        return items;
    }

    public List<CharacterClass> getCharacterClasses() {
        return characterClasses;
    }

    public void setCharacterClasses(List<CharacterClass> characterClasses) {
        this.characterClasses = characterClasses;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", items=" + items +
                ", characterClasses=" + characterClasses +
                '}';
    }
}
