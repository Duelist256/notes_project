package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "enote.notebooks")
public class Notebook {

    @Id
    @Column(name = "id")
    private int id;

    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

        Notebook notebook = (Notebook) obj;

        if (id != notebook.getId()) {
            return false;
        }

        if (userId != notebook.getUserId()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + userId;
        return result;
    }

    public class Builder {
        private Builder() {}

        public Builder id(int id) {
            Notebook.this.id = id;
            return this;
        }

        public Builder userId(int userId) {
            Notebook.this.userId = userId;
            return this;
        }

        public Notebook build() {
            return Notebook.this;
        }
    }
}
