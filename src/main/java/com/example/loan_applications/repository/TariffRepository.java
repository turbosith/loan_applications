package com.example.loan_applications.repository;


import com.example.loan_applications.model.Tariff;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TariffRepository {
    private static final String TARIFFS = "SELECT * FROM tariff";
    private final JdbcTemplate jdbcTemplate;

    public Optional<List<Tariff>> findAll() {
        return Optional.of(jdbcTemplate.query(
                TARIFFS,
                new BeanPropertyRowMapper<>(Tariff.class)
        ));
    }


}