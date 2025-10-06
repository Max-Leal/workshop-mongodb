package com.max.workshopmongodb.dto;

import com.max.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

}
