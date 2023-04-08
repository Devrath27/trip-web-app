package com.trip.backend.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ExceptionResponse> exceptionResponses = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = ((FieldError) error).getField() + " " + error.getDefaultMessage();
            exceptionResponses.add(new ExceptionResponse("InvalidRequest", errorMessage));
        });
        return new ResponseEntity<>(exceptionResponses, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<Object> handlerUserAlreadyExistsException(UserAlreadyExistsException ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("UserExists", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handlerUserNameNotFoundException(UserNotFoundException ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("InvalidUser", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({InvalidLoginCredential.class})
    public ResponseEntity<Object> handlerInvalidLoginCredentialException(InvalidLoginCredential ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("InvalidCredential", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler({ForbiddenRequestException.class})
    public ResponseEntity<Object> handlerForbiddenRequestException(ForbiddenRequestException ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("Forbidden", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<Object> handlerInvalidTokenException(InvalidTokenException ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("InvalidToken", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler({TokenExpiredException.class})
    public ResponseEntity<Object> handlerTokenExpiredException(TokenExpiredException ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("Expired", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handlerException(Exception ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("Unknown", ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
