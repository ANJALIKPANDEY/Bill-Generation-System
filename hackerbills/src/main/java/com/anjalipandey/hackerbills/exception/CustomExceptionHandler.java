package com.anjalipandey.hackerbills.exception;

import com.anjalipandey.hackerbills.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception Handler Class
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String BAD_REQUEST = "400";

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e, WebRequest webRequest){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getLocalizedMessage())
                .statusCode(BAD_REQUEST)
                .build();

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException e, WebRequest webRequest){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getLocalizedMessage())
                .statusCode(BAD_REQUEST)
                .build();

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
