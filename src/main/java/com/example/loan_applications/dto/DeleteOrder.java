package com.example.loan_applications.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class DeleteOrder {
    private long userId;
    private UUID orderId;
}
