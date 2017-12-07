package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Basic
    @Column(name = "login")
    String login;

    @Basic
    @Column(name = "password")
    String password;

    @Basic
    @Column(name = "name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public class Builder{

        private Builder(){

        }

        public Builder id(int id){
            User.this.id = id;
            return this;
        }

        public Builder login(String login){
            User.this.login = login;
            return this;
        }

        public Builder password(String password){
            User.this.password = password;
            return this;
        }

        public Builder name(String name){
            User.this.name = name;
            return this;
        }

        public User build(){
            return User.this;
        }
    }

}
