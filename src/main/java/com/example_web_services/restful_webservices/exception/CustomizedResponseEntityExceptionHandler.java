package com.example_web_services.restful_webservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;

import com.example_web_services.restful_webservices.user.UserNotFoundException;

 @ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex,  WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
        ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }//gives 500 response
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNOtFoundException(Exception ex,  WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
        ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }//n gives 404 response
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
        "Total errors : "+ex.getErrorCount()+" first error: "+ex.getFieldError().getDefaultMessage(),request.getDescription(false));
        
        return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);

	}




}
