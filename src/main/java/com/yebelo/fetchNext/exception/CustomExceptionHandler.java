package com.yebelo.fetchNext.exception;

import com.yebelo.fetchNext.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    /**
     * custom exception handler method for handling when the user enters the category code which is not present in hte database
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(CategoryCodeNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleFacultyNotFoundException(CategoryCodeNotFoundException e, WebRequest request){
        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
