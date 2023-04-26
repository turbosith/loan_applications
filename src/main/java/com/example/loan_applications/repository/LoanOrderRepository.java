package com.example.loan_applications.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class LoanOrderRepository {


    private static final  String OFFERS = "SELECT * FROM OFFERS";
    private static final  String OFFERS_BY_ID = "SELECT * FROM OFFERS WHERE USERID = ?";
    private static final  String SAVE = "insert into OFFERS (HEADING, DESCRIPTION, USERID) values (?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;
   /* public List<OfferEntity> findAll(){
        return jdbcTemplate.query(
                OFFERS,
                new BeanPropertyRowMapper<>(OfferEntity.class)
        );
    }
    public List<OfferEntity> findAllByUserId(Long id){
        return jdbcTemplate.query(
                OFFERS_BY_ID,
                new Object[]{id},
                new BeanPropertyRowMapper<>(OfferEntity.class)
        );
    }

    public OfferEntity save(OfferEntity offer){
        jdbcTemplate.update(
                SAVE,
                offer.getHeading(),
                offer.getDescription(),
                offer.getUser()
        );
        return offer;
    }*/


}
