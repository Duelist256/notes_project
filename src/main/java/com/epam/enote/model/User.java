package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "enote.users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;

    private String password;

    private String name;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (id != user.getId()) {
            return false;
        }

        if (!login.equals(user.getLogin())) {
            return false;
        }

        if (!password.equals(user.getPassword())) {
            return false;
        }

        if (!name.equals(user.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
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
