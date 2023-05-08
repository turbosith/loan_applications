package com.example.loan_applications.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataException {
    private String code;
    private String message;
}
