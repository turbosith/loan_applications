package com.example.loan_applications.service;

import com.example.loan_applications.dto.ApplicationSubmission;
import com.example.loan_applications.dto.LoanOrderDTO;
import com.example.loan_applications.dto.LoanOrderSuccess;

import java.util.UUID;

public interface LoanOrderService {
    LoanOrderSuccess add(ApplicationSubmission applicationSubmission);
}
