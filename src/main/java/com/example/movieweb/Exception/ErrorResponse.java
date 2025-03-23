package com.example.movieweb.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

@Data
@AllArgsConstructor
public class ErrorResponse implements org.springframework.web.ErrorResponse {
    private String message;
    private int status;

    @Override
    public HttpStatusCode getStatusCode() {
        return null;
    }

    @Override
    public ProblemDetail getBody() {
        return null;
    }
}
