package com.trip.backend.service;

import com.trip.backend.controller.dto.*;
import com.trip.backend.exceptions.UserAlreadyExistsException;
import com.trip.backend.exceptions.UserNotFoundException;
import com.trip.backend.model.User;
import com.trip.backend.repository.UserRepository;
import com.trip.backend.utils.JwtUtil;
import com.trip.backend.utils.LoadByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String USER_ALREADY_EXISTS = "User already exist";
    public static final String USER_NOT_FOUND = "User Not Found";
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
     JavaMailSender javaMailSender;
    private JwtUtil jwtUtil;
    LoadByUsername loadByUsername;
    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder,JavaMailSender javaMailSender,JwtUtil jwtUtil,LoadByUsername loadByUsername){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.javaMailSender=javaMailSender;
        this.jwtUtil=jwtUtil;
        this.loadByUsername=loadByUsername;
    }

    public RegistrationResponse createUser(CreateUserRequest userRequest) throws UserAlreadyExistsException {
        if (!userRepository.existByEmail(userRequest.getEmail()).isEmpty()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }
        User user = new User(userRequest.getEmail(), passwordEncoder.encode(userRequest.getPassword()),userRequest.getName(),userRequest.getMobileNumber(),userRequest.getProfileImage());
        this.userRepository.create(user);

        return new RegistrationResponse(jwtUtil.generateToken(loadByUsername.loadUserByUsername(userRequest.getEmail())));
    }

    public GetProfileResponse getProfile(String email) throws UserNotFoundException {
      Optional<User> user = this.userRepository.existByEmail(email);
      if(user.isEmpty()){
          throw new UserNotFoundException(USER_NOT_FOUND);
      }
        return new GetProfileResponse(user.get().getEmail(),user.get().getName(),user.get().getMobileNumber(),user.get().getProfileImage());
    }

    public SentEmailResponse sentEmail(String email, SentEmailRequest sentEmailRequest) {
        String to = email;
        String subject = "Registration verification mail";
        String body = "Hi User"+"\n"+"The OTP for the verification of mail-"+email+" is : "+sentEmailRequest.getOtp();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        return new SentEmailResponse("Email sent successfully");
    }
}
