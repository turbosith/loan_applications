package com.example.loan_applications.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteOrder {
    private long userId;
    private UUID orderId;
}
