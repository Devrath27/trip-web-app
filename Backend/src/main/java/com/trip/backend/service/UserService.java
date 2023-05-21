package com.trip.backend.service;

import com.trip.backend.controller.dto.CreateUserRequest;
import com.trip.backend.controller.dto.GetProfileResponse;
import com.trip.backend.exceptions.UserAlreadyExistsException;
import com.trip.backend.exceptions.UserNotFoundException;
import com.trip.backend.model.User;
import com.trip.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String USER_ALREADY_EXISTS = "User already exist";
    public static final String USER_NOT_FOUND = "User Not Found";
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public String createUser(CreateUserRequest userRequest) throws UserAlreadyExistsException {
        if (!userRepository.existByEmail(userRequest.getEmail()).isEmpty()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }
        User user = new User(userRequest.getEmail(), passwordEncoder.encode(userRequest.getPassword()),userRequest.getName(),userRequest.getMobileNumber(),userRequest.getProfileImage());
        return this.userRepository.create(user);
    }

    public GetProfileResponse getProfile(String email) throws UserNotFoundException {
      Optional<User> user = this.userRepository.existByEmail(email);
      if(user.isEmpty()){
          throw new UserNotFoundException(USER_NOT_FOUND);
      }
        return new GetProfileResponse(user.get().getEmail(),user.get().getName(),user.get().getMobileNumber(),user.get().getProfileImage());
    }
}
