package com.luv2code.cruddemo.controllers.exception;

import com.luv2code.cruddemo.controllers.response.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse
                .setMessage(exception.getMessage())
                .setStatus(HttpStatus.BAD_REQUEST.value())
                .setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
