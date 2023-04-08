package com.trip.backend.repository;

import com.trip.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    JPAUserRepository jpaUserRepository;

    @Autowired
    public UserRepository(JPAUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
    public Optional<User> existByEmail(String email) {

        return jpaUserRepository.findByEmail(email);

    }
    public String create(User user) {
        return this.jpaUserRepository.save(user).getEmail();
    }

}
