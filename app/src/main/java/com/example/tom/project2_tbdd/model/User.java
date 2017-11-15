package com.example.tom.project2_tbdd.model;

import java.io.Serializable;

/**
 * Created by tom on 11/6/2017.
 */

public class User implements Serializable {

    private long id;
    private String username;
    private String password;
    private String email;
    private long genre;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getGenre() {
        return genre;
    }

    public void setGenre(long genre) {
        this.genre = genre;
    }
}