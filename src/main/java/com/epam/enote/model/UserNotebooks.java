package com.epam.enote.model;

import javax.persistence.*;

@Entity
@Table(name = "user_notebooks")
public class UserNotebooks {
    @Basic
    @Column(name = "userId")
    int userId;

    @Basic
    @Column(name = "notebookId")
    int notebookId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(int notebookId) {
        this.notebookId = notebookId;
    }

    public class Builder {
        private Builder() {}

        public Builder userId(int userId) {
            UserNotebooks.this.userId = userId;
            return this;
        }

        public Builder notebookId(int notebookId) {
            UserNotebooks.this.notebookId = notebookId;
            return this;
        }

        public UserNotebooks build() {
            return UserNotebooks.this;
        }
    }
}
