package com.max.workshopmongodb.services;

import com.max.workshopmongodb.domain.Post;
import com.max.workshopmongodb.repository.PostRepository;
import com.max.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        //User user = repo.findOne(id);
        //if (user == null) {
        // throw new ObjectNotFoundException("User not found");
        // }
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found: " + id));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
