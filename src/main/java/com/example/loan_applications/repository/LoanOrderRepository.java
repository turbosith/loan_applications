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
    private static final String SELECT_BY_ORDERID = "SELECT STATUS FROM loan_order WHERE order_id=?";
    private static final String UPDATE = "update LOAN_ORDER set STATUS = ?, TIME_UPDATE = ? where ID = ?";
    private static final String SELECT_BY_ORDERID_AND_USERID = "SELECT STATUS FROM loan_order WHERE order_id=? AND user_id=?";
    private final JdbcTemplate jdbcTemplate;

    /**
     * Метод добавления заявки
     * @param loanOrder - заявка
     */
    public void save(LoanOrder loanOrder) {
        jdbcTemplate.update(
                SAVE,
                loanOrder.getOrderId(),
                loanOrder.getUserId(),
                loanOrder.getTariffId(),
                loanOrder.getCreditRating(),
                loanOrder.getStatus().toString(),
                loanOrder.getTimeInsert()
        );
    }

    /**
     * Метод нахождения по идентификатору пользователя
     * @param userId - id пользователя
     * @return - заявки пользователя
     */
    public List<LoanOrder> findByUserId(long userId) {
        return jdbcTemplate.query(
                SELECT_BY_USERID,
                new BeanPropertyRowMapper<>(LoanOrder.class),
                userId
        );
    }

    /**
     * Метод получения заявок по статусу
     * @param statusEnum - статус заявки
     * @return - заявки с определенным статусом
     */
    public List<LoanOrder> findByStatus(StatusEnum statusEnum) {
        return jdbcTemplate.query(
                SELECT_BY_STATUS,
                new BeanPropertyRowMapper<>(LoanOrder.class),
                statusEnum.toString()
        );
    }

    /**
     * Метод получения статуса заявки
     * @param orderId - идентификатор заяки
     * @return - статус
     */
    public Optional<GetOrderStatusSuccess> getStatusByOrderId(String orderId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SELECT_BY_ORDERID,
                    GetOrderStatusSuccess.class,
                    orderId
            ));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    /**
     * Метод получения статуса по id пользователя и заявки
     * @param userId - идентификатор пользователя
     * @param orderId - идентификатор заявки
     * @return - статус
     */
    public Optional<GetOrderStatusSuccess> getStatusByOrderIdAndUserId(long userId, UUID orderId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SELECT_BY_ORDERID_AND_USERID,
                    GetOrderStatusSuccess.class,
                    orderId.toString(),
                    userId
            ));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    /**
     * Метод удаления заявки
     * @param userId - идентификатор пользователя
     * @param orderId - идентификатор заявки
     */
    public void deleteByOrderIdAndUserId(long userId, UUID orderId) {
        jdbcTemplate.update(
                DELETE,
                orderId.toString(),
                userId

        );
    }

    /**
     * Изменение статуса заявки
     * @param status - статус заявки
     * @param timesUpdate - время изменения заявки
     * @param id - иденитификатор заявки
     */
    public void updateLoanOrder(StatusEnum status, Timestamp timesUpdate, long id) {
        jdbcTemplate.update(
                UPDATE,
                status.toString(),
                timesUpdate,
                id
        );

    }
}
