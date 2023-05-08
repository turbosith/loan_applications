package com.example.loan_applications.service;

import com.example.loan_applications.dto.TariffDTO;
import com.example.loan_applications.model.Tariff;

import java.util.List;

public interface TariffService {
    List<Tariff> findAll();

    int save(TariffDTO tariffDTO);

    Tariff getById(long id);

}
