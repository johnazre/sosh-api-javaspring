package com.sosh.api.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;
    private String email;
    private String bio;
    private String profilePhotoUrl;
    private String location;
    private Date created_at;
    private Date updated_at;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Status> statuses = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "sender_id")
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "recipient_id")
    private List<Message> recievedMessages = new ArrayList<>();

    // No-arg constructor for Hibernate
    public User() {}

    public User(String name, String email, String bio, String profilePhotoUrl, String location, Date created_at, Date updated_at) {
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.profilePhotoUrl = profilePhotoUrl;
        this.location = location;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
