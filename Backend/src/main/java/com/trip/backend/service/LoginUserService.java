package com.trip.backend.service;

import com.trip.backend.controller.dto.LoginResponse;
import com.trip.backend.controller.dto.UserLoginRequest;
import com.trip.backend.exceptions.InvalidLoginCredential;
import com.trip.backend.repository.UserRepository;
import com.trip.backend.utils.JwtUtil;
import com.trip.backend.utils.LoadByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {
    public static final String INVALID_LOGIN_CREDENTIAL = "Invalid Login Credential";
    UserRepository userRepository;
    AuthenticationManager authenticationManager;
    LoadByUsername loadByUsername;
    private JwtUtil jwtUtil;

    @Autowired
    public LoginUserService(UserRepository userRepository, JwtUtil jwtUtil, LoadByUsername loadByUsername, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.loadByUsername = loadByUsername;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse createAuthenticationToken(UserLoginRequest userRequest) throws InvalidLoginCredential, Exception {
        authenticateUser(userRequest);
        return new LoginResponse(jwtUtil.generateToken(loadByUsername.loadUserByUsername(userRequest.getEmail())));
    }

    private void authenticateUser(UserLoginRequest userRequest) throws Exception, InvalidLoginCredential {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(),
                    userRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new InvalidLoginCredential(INVALID_LOGIN_CREDENTIAL);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
