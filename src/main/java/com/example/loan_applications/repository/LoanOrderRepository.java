package com.example.loan_applications.repository;

import com.example.loan_applications.constants.StatusEnum;
import com.example.loan_applications.dto.GetOrderStatusSuccess;
import com.example.loan_applications.model.LoanOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoanOrderRepository {
    private static final String SAVE = "insert into LOAN_ORDER (ORDER_ID, USER_ID, TARIFF_ID, CREDIT_RATING, STATUS, TIME_INSERT) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_USERID = "SELECT * FROM loan_order WHERE user_id=?";
    private static final String SELECT_BY_STATUS = "SELECT * FROM loan_order WHERE status=?";
    private static final String DELETE = "DELETE FROM loan_order WHERE order_id=? AND user_id=?";
    private static final String SELECT_BY_ORDERID="SELECT STATUS FROM loan_order WHERE order_id=?";
    private final String UPDATE = "update LOAN_ORDER set STATUS = ?, TIME_UPDATE = ? where ID = ?";
    private static final String SELECT_BY_ORDERID_AND_USERID = "SELECT STATUS FROM loan_order WHERE order_id=? AND user_id=?";
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
    public List<LoanOrder> findByStatus(StatusEnum statusEnum) {
        return jdbcTemplate.query(
                SELECT_BY_STATUS,
                new BeanPropertyRowMapper<>(LoanOrder.class),
                statusEnum.toString()
        );
    }


    public Optional<GetOrderStatusSuccess> getStatusByOrderId(String orderId) {
        try{
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                SELECT_BY_ORDERID,
                GetOrderStatusSuccess.class,
                orderId
        ));}
        catch (EmptyResultDataAccessException exception){
            return Optional.empty();
        }
    }



    public Optional<GetOrderStatusSuccess> getStatusByOrderIdAndUserId(long userId, UUID orderId) {
        try{
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SELECT_BY_ORDERID_AND_USERID,
                    GetOrderStatusSuccess.class,
                    orderId.toString(),
                    userId
            ));}
        catch (EmptyResultDataAccessException exception){
            return Optional.empty();
        }
    }

    public int deleteByOrderIdAndUserId(long userId, UUID orderId) {
        return jdbcTemplate.update(
                DELETE,
                orderId.toString(),
                userId

        );
    }

    public int updateLoanOrder(StatusEnum status, Timestamp timesUpdate, long id) {
        return jdbcTemplate.update(
                UPDATE,
                status.toString(),
                timesUpdate,
                id
        );

    }
}
