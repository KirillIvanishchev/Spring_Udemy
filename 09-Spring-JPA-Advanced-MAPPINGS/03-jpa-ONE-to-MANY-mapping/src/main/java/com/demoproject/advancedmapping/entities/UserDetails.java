package com.demoproject.advancedmapping.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user_detail")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="profile_link")
    private String profile_link;


    @Column(name="description")
    private String description;

    //@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)

    //Only to Delete DETAILS. We need to use cascade type Array to do this.
    //In cascade types choose all except REMOVE.
    @OneToOne(mappedBy="userDetails", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetails() {}

    public UserDetails(String profile_link, String description) {
        this.profile_link = profile_link;
        this.description = description;
    }

    public String getProfileLink() {
        return profile_link;
    }

    public void setProfileLink(String profile_link) {
        this.profile_link = profile_link;
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
                ", profile='" + profile_link + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
