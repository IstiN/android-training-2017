package com.example.evgen.myapplication.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by evgen on 12.10.2017.
 */

@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private String avatar;

    public User() {
    }

    public User(Long id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }
}
