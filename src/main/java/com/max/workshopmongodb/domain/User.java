package com.max.workshopmongodb.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public User() {}

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
