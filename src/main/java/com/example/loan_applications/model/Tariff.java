package com.example.loan_applications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tariff {
    private long id;
    private String type;
    private String interestRate;
}
