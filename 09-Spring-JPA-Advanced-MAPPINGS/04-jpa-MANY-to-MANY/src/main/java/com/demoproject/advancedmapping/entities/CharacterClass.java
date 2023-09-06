package com.demoproject.advancedmapping.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_role")
    private String classRole;

    @Column(name = "class_skill")
    private String classSkill;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH}
    )
    @JoinTable(
        name = "playable_character-class",
        joinColumns = @JoinColumn(name = "class_id"),
        inverseJoinColumns = @JoinColumn(name = "playable_character_id")
    )
    List<Character> characters;

    public void addCharacter(Character character) {
        if (characters == null) {
            characters = new ArrayList<>();
        }
        characters.add(character);
    }
    public CharacterClass() {}

    public CharacterClass(String classRole, String classSkill, String description) {
        this.classRole = classRole;
        this.classSkill = classSkill;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassRole() {
        return classRole;
    }

    public void setClassRole(String classRole) {
        this.classRole = classRole;
    }

    public String getClassSkill() {
        return classSkill;
    }

    public void setClassSkill(String classSkill) {
        this.classSkill = classSkill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "CharacterClass{" +
                "id=" + id +
                ", classRole='" + classRole + '\'' +
                ", classSkill='" + classSkill + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
