package com.max.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.max.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
