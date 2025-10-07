package com.max.workshopmongodb.services;

import com.max.workshopmongodb.domain.User;
import com.max.workshopmongodb.dto.UserDTO;
import com.max.workshopmongodb.repository.UserRepository;
import com.max.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        //User user = repo.findOne(id);
        //if (user == null) {
        // throw new ObjectNotFoundException("User not found");
        // }
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found: " + id));
    }

    public User insert(User user) {
        return repo.insert(user);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
