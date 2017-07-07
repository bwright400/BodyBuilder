package com.example.bwright.bodybuilder;

import java.util.HashMap;

/**
 * Created by bwrig on 7/6/2017.
 */

public class User {
    private String name, uid, email, password;

    public User() {

    }

    public User(String name, String uid, String email, String password) {
        this.setName(name);
        this.setUid(uid);
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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


    public HashMap<String, String> profile() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Name", getName());
        map.put("Email", getEmail());
        map.put("Password", getPassword());
        map.put("uid", getUid());
        return map;
    }
}
