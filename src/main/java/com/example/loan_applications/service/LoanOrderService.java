package com.example.loan_applications.service;

import com.example.loan_applications.dto.LoanOrderDTO;

import java.util.UUID;

public interface LoanOrderService {
    LoanOrderDTO findById(UUID id);
}
