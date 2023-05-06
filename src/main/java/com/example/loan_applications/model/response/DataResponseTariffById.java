package com.example.loan_applications.model.response;

import com.example.loan_applications.model.Tariff;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DataResponseTariffById {
    private Tariff tariff;
}
