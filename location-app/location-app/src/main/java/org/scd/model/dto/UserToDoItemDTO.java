package org.scd.model.dto;

import org.scd.model.User;

import javax.persistence.*;

public class UserToDoItemDTO {
    private String name;
    private boolean complete;
    private String email;

    public UserToDoItemDTO(String name, boolean complete, String email) {
        this.name = name;
        this.complete = complete;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
