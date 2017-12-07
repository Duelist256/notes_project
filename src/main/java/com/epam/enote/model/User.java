package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends Base {

    @Basic
    @Column(name = "login")
    String login;

    @Basic
    @Column(name = "password")
    String password;

    @Basic
    @Column(name = "name")
    String name;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
