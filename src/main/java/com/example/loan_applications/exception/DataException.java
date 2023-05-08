package com.example.loan_applications.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class DataException {
    private String code;
    private String message;
}
