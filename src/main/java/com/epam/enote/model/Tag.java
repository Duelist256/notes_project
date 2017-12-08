package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Basic
    @Column(name = "id")
    int id;

    @Basic
    @Column(name = "name")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        Tag tag = (Tag) obj;

        if (id != tag.getId()) {
            return false;
        }

        if (name != tag.getName()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * id + (name != null ? name.hashCode() : 0);
        return result;
    }

    public class Builder {
        private Builder() {}

        public Builder id(int id) {
            Tag.this.id = id;
            return this;
        }

        public Builder name(String name) {
            Tag.this.name = name;
            return this;
        }

        public Tag build() {
            return Tag.this;
        }
    }
}
