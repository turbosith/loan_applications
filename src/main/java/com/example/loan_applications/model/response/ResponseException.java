package com.example.loan_applications.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseException<T> {
    private T error;
}
