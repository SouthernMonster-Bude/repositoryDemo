package com.hjm.test.dto;

public class User {

    private String id;
    private String username;

    public User(){
        System.out.println("new User() "+this+" created!");
    }

    public User(String id, String username) {
        System.out.println("User("+id+", "+username+")  "+this+"  created!");
        this.id = id;
        this.username = username;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}