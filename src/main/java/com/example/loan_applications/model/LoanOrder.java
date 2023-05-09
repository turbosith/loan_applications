package com.example.loan_applications.model;

import java.sql.Timestamp;

import com.example.loan_applications.constants.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanOrder {
    private long id;
    private String orderId;
    private long userId;
    private long tariffId;
    private double creditRating;
    private StatusEnum status;
    private Timestamp timeInsert;
    private Timestamp timeUpdate;

    public LoanOrder(String orderId, long userId, long tariffId,
                     double creditRating, StatusEnum status, Timestamp timeInsert) {
        this.orderId = orderId;
        this.userId = userId;
        this.tariffId = tariffId;
        this.creditRating = creditRating;
        this.status = status;
        this.timeInsert = timeInsert;
    }

}
