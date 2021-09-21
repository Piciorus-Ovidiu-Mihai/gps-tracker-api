package org.scd.model;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TODOLIST")
public class UserToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Column(name = "COMPLETE", nullable = false, length = 45)
    private boolean complete;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserToDoItem(){

    }

    public UserToDoItem(String name, boolean complete, User user) {
        this.name = name;
        this.complete = complete;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
