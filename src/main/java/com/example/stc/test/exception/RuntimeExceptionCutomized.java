package com.example.stc.test.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@Getter
@Setter
public class RuntimeExceptionCutomized extends RuntimeException {

    String message;
    HttpStatus status;
    public RuntimeExceptionCutomized(String message, HttpStatus status) {

        this.message=message;
        this.status=status;

    }
}
