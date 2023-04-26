package com.example.loan_applications.model;
import java.sql.Timestamp;
import com.example.loan_applications.constants.StatusEnum;
import lombok.Data;

@Data
public class LoanOrder {
    private long id;
    private String orderId;
    private long userId;
    private long tariffId;
    private double creditRating;
    private StatusEnum status;
    private Timestamp timeInsert;
    private Timestamp timeUpdate;


}
