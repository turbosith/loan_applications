package com.example.loan_applications;

import com.example.loan_applications.service.TariffService;
import com.example.loan_applications.service.impl.TariffServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TariffIntegrationTest {

    @Autowired
    private TariffService tariffService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getTariffsTest(){

    }
    @Test
    public void addTariffTest(){

    }
}