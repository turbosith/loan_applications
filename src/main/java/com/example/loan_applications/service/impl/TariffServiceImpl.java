package com.example.loan_applications.service.impl;

import com.example.loan_applications.dto.TariffDTO;
import com.example.loan_applications.model.Tariff;
import com.example.loan_applications.repository.TariffRepository;
import com.example.loan_applications.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;

    @Override
    public List<Tariff> findAll() {

        return tariffRepository.findAll().orElseThrow();
    }

    @Override
    public int save(TariffDTO tariffDTO) {
        Tariff tariff = new Tariff();
        tariff.setType(tariffDTO.getType());
        tariff.setInterestRate(tariffDTO.getInterest_rate());
        return tariffRepository.save(tariff);
    }

    @Override
    public Tariff getById(long id) {
        return tariffRepository.getById(id).orElseThrow();
    }
}
