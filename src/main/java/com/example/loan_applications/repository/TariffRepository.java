package com.example.loan_applications.repository;


import com.example.loan_applications.model.Tariff;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TariffRepository {
    private static final String TARIFFS = "SELECT * FROM tariff";
    private static final String EXISTS = "SELECT EXISTS(SELECT * FROM tariff WHERE id=?)";
    private static final String TARIFF = "SELECT * FROM tariff WHERE id=?";
    private static final String SAVE = "insert into TARIFF (TYPE, INTEREST_RATE) values (?, ?)";
    private final JdbcTemplate jdbcTemplate;

    /**
     * Метод полученяи всех тарифов
     * @return - список тарифов
     */
    public Optional<List<Tariff>> findAll() {
        return Optional.of(jdbcTemplate.query(
                TARIFFS,
                new BeanPropertyRowMapper<>(Tariff.class)
        ));
    }

    /**
     * метод сохранения тарифа
     * @param tariff - тариф
     * @return - результат
     */
    public int save(Tariff tariff) {
        return jdbcTemplate.update(
                SAVE,
                tariff.getType(),
                tariff.getInterestRate()
        );
    }

    /**
     * Получение тарифа по id
     * @param id -идентификатор тарифа
     * @return - тариф
     */
    public Optional<Tariff> getById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                TARIFF,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Tariff.class)
        ));
    }

    /**
     * Получение наличия тарифа
     * @param tariffId - идентификатор тарифа
     * @return - наличие тарифа
     */
    public Boolean existsById(long tariffId) {
        return jdbcTemplate.queryForObject(EXISTS, Boolean.class, tariffId);
    }


}