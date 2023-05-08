package com.example.loan_applications.dto;

import com.example.loan_applications.constants.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetOrderStatusSuccess {
    private String orderStatus;
}
