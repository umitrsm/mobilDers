package com.example.mobilders;


public class Person {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;

    Person(String username,String email,String password){
        this.email=email;
        this.password=password;
        this.username=username;
    }
    Person(String username,String password){
        this.username=username;
        this.password=password;
    }
}
