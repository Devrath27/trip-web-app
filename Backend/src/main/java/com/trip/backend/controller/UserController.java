package com.trip.backend.controller;

import com.trip.backend.controller.dto.*;
import com.trip.backend.exceptions.InvalidLoginCredential;
import com.trip.backend.exceptions.UserAlreadyExistsException;
import com.trip.backend.exceptions.UserNotFoundException;
import com.trip.backend.service.LoginUserService;
import com.trip.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    private static final String USER_SUCCESSFULLY_REGISTERED = "User Successfully Registered";
    UserService userService;
    private LoginUserService loginUserService;

    @Autowired
    public UserController(UserService userService,LoginUserService loginUserService) {
        this.userService = userService;
        this.loginUserService=loginUserService;
    }
    @GetMapping("users/{email}")
    public GetProfileResponse getProfile(@PathVariable String email) throws UserNotFoundException {
        return this.userService.getProfile(email);
    }

    @PostMapping("/users/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationResponse createUser(@Valid @RequestBody CreateUserRequest userRequest) throws UserAlreadyExistsException {
        this.userService.createUser(userRequest);
        return new RegistrationResponse(USER_SUCCESSFULLY_REGISTERED);

    }
    @PostMapping("/users/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse createAuthenticationToken(@Valid @RequestBody UserLoginRequest userLoginRequest) throws InvalidLoginCredential, Exception {
        return this.loginUserService.createAuthenticationToken(userLoginRequest);
    }
    @PostMapping("/users/verifyEmail/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    public SentEmailResponse sentEmail(@Valid @PathVariable("email") String email , @RequestBody SentEmailRequest sentEmailRequest){
        System.out.println(sentEmailRequest.getOtp());
           return this.userService.sentEmail(email,sentEmailRequest);
    }


}
