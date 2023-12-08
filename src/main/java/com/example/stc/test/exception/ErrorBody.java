package com.example.stc.test.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ErrorBody {
    HttpStatus status;
    String message;

    public ErrorBody(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
