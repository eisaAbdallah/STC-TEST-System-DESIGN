package com.example.stc.test.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ContrllerAdviceException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            =   RuntimeExceptionCutomized.class  )
    protected ResponseEntity<Object> handleConflict(
            RuntimeExceptionCutomized ex, WebRequest request) {
        ErrorBody errorBody=new ErrorBody();
        errorBody.setMessage(ex.getMessage());
        errorBody.setStatus(ex.getStatus());

        return handleExceptionInternal(ex, errorBody,
                new HttpHeaders(), ex.getStatus(), request);
    }

}
