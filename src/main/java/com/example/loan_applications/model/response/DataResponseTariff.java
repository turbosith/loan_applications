package com.example.loan_applications.model.response;

import com.example.loan_applications.model.Tariff;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DataResponseTariff {
    private List<Tariff> tariffs;
}
