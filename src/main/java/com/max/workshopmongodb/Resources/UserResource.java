package com.max.workshopmongodb.Resources;

import com.max.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1","maria","maria@gmail.com");
        User leo = new User("2","leo","leo@gmail.com");
        User lucas = new User("3","lucas","lucas@gmail.com");
        List<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(maria, leo, lucas));
        return ResponseEntity.ok().body(users);
    }

}
