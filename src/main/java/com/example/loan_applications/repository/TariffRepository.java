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
    private static final String TARIFF = "SELECT * FROM tariff WHERE id=?";
    private static final String SAVE = "insert into TARIFF (TYPE, INTEREST_RATE) values (?, ?)";
    private final JdbcTemplate jdbcTemplate;

    public Optional<List<Tariff>> findAll() {
        return Optional.of(jdbcTemplate.query(
                TARIFFS,
                new BeanPropertyRowMapper<>(Tariff.class)
        ));
    }
    public int save(Tariff tariff){
        return jdbcTemplate.update(
                SAVE,
                tariff.getType(),
                tariff.getInterestRate()
        );
    }
    public  Optional<Tariff> getById(long id){
        return Optional.ofNullable((Tariff) jdbcTemplate.queryForObject(
                TARIFF,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Tariff.class)
        ));
    }


}