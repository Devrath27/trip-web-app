package com.trip.backend.utils;

import com.trip.backend.model.User;
import com.trip.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class LoadByUsername implements UserDetailsService {
    public static final String NOT_FOUND = " not found.";
    UserRepository userRepository;

    @Autowired
    public LoadByUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.existByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email + NOT_FOUND);
        }
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(),
                new ArrayList<>());
    }
}
