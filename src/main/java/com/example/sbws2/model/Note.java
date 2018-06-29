package com.example.sbws2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="notes")
public class Note {

    @Id
    private Long id;
    private String title;
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore //avoid infinity loop - user retrieving posts / posts retrieving user
    private User user;

    public Note(){}

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Note(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
