package com.example.loan_applications.repository;

import com.example.loan_applications.dto.GetOrderStatusSuccess;
import com.example.loan_applications.model.LoanOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoanOrderRepository {
    private static final String SAVE = "insert into LOAN_ORDER (ORDER_ID, USER_ID, TARIFF_ID, CREDIT_RATING, STATUS, TIME_INSERT) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_USERID = "SELECT * FROM loan_order WHERE user_id=?";
    private static final String SELECT_BY_ORDERID="SELECT STATUS FROM loan_order WHERE order_id=?";
    private final JdbcTemplate jdbcTemplate;

    public int save(LoanOrder loanOrder) {
        return jdbcTemplate.update(
                SAVE,
                loanOrder.getOrderId(),
                loanOrder.getUserId(),
                loanOrder.getTariffId(),
                loanOrder.getCreditRating(),
                loanOrder.getStatus().toString(),
                loanOrder.getTimeInsert()
        );
    }
    public List<LoanOrder> findByUserId(long userId) {
        return jdbcTemplate.query(
                SELECT_BY_USERID,
                new BeanPropertyRowMapper<>(LoanOrder.class),
                userId
        );
    }


    public LoanOrder getStatusByOrderId(String orderId) {
        return jdbcTemplate.queryForObject(
                SELECT_BY_ORDERID,
                new Object[]{orderId},
                new BeanPropertyRowMapper<>(LoanOrder.class)
        );
    }
}
