package com.example.loan_applications.repository;

import com.example.loan_applications.model.LoanOrder;
import com.example.loan_applications.model.Tariff;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class LoanOrderRepository {
    private static final String SAVE = "insert into LOAN_ORDER (ORDER_ID," +
            " USER_ID,TARIFF_ID,CREDIT_RATING,STATUS,TIME_INSERT) values (?, ?, ?, ?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;
    public int save(LoanOrder loanOrder){
        return jdbcTemplate.update(
                SAVE,
                loanOrder.getOrderId(),
                loanOrder.getUserId(),
                loanOrder.getTariffId(),
                loanOrder.getCreditRating(),
                loanOrder.getStatus(),
                loanOrder.getTimeInsert()
        );}


}
