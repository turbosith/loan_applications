package com.example.loan_applications.controller;

import com.example.loan_applications.dto.LoanOrderDTO;
import com.example.loan_applications.dto.TariffDTO;
import com.example.loan_applications.model.Tariff;
import com.example.loan_applications.model.response.DataResponse;
import com.example.loan_applications.model.response.DataResponseTariff;
import com.example.loan_applications.service.LoanOrderService;
import com.example.loan_applications.service.TariffService;
import com.example.loan_applications.service.impl.LoanOrderServiceImpl;
import com.example.loan_applications.service.impl.TariffServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/loan-service")
public class LoanOrderController {
    private final TariffService tariffService;
    //private final LoanOrderService loanOrderService;

    @GetMapping("/getTariffs")
    public ResponseEntity<DataResponse> getTariffs(Model model) {
        return ResponseEntity.ok(new DataResponse(new DataResponseTariff(tariffService.findAll())));
    }
/*
    @GetMapping("/order")
    public String newOrder(Model model) {
        model.addAttribute("order", new LoanOrderDTO());
        return "";
    }

    @PostMapping
    public ResponseEntity<LoanOrderDTO> createNewOrder(@ModelAttribute("order") LoanOrderDTO order) throws NotActiveException {
        LoanOrderServiceImpl.save(order);
        throw new NotActiveException();
    }

    @GetMapping("/getStatusOrder/{orderid}")
    public String getOrder(@PathVariable(value = "id") UUID id, Model model) {
        LoanOrderDTO order = loanOrderService.findById(id);
        return "";
    }

    @DeleteMapping("/deleteOrder}")
    public String deleteOrder(Model model) {
        return "";
    }*/

}
