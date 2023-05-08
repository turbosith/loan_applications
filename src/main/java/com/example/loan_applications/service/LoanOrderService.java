package com.example.loan_applications.service;

import com.example.loan_applications.dto.ApplicationSubmission;
import com.example.loan_applications.dto.GetOrderStatusSuccess;
import com.example.loan_applications.dto.LoanOrderSuccess;

public interface LoanOrderService {
    LoanOrderSuccess add(ApplicationSubmission applicationSubmission);
    GetOrderStatusSuccess getStatus(String orderId);
}
