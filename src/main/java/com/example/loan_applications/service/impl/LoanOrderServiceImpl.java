package com.example.loan_applications.service.impl;

import com.example.loan_applications.dto.ApplicationSubmission;
import com.example.loan_applications.dto.LoanOrderDTO;
import com.example.loan_applications.dto.LoanOrderSuccess;
import com.example.loan_applications.exception.CustomException;
import com.example.loan_applications.model.LoanOrder;
import com.example.loan_applications.repository.TariffRepository;
import com.example.loan_applications.service.LoanOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class LoanOrderServiceImpl implements LoanOrderService {
    private final TariffRepository tariffRepository;
    @Override
    public LoanOrderSuccess add(ApplicationSubmission applicationSubmission) {
        if(tariffRepository.getById(applicationSubmission.getTariffid())==null){
            throw new CustomException("TARIFF_NOT_FOUND","Тариф не найден");
        }
        return null;
    }
}
