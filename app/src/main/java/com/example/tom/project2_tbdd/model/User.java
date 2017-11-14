package com.example.tom.project2_tbdd.model;

/**
 * Created by tom on 11/6/2017.
 */

public class User {


    private String username;
    private String password;
    private String email;
    private long genre;

    public User(String username, String password, String email, long genre) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.genre = genre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getGenre() {
        return genre;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenre(long genre) {
        this.genre = genre;
    }
}
