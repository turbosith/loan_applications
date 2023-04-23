package com.example.loan_applications.controller;

import com.example.loan_applications.dto.LoanOrderDTO;
import com.example.loan_applications.service.impl.LoanOrderServiceImpl;
import com.example.loan_applications.service.impl.TariffServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/loan-service")
public class LoanOrderController {
    private final TariffServiceImpl tariffService;
    private final LoanOrderServiceImpl loanOrderService;

    @GetMapping("/getTariffs")
    public String getTariffs(Model model) {
        return null;
    }

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
    }

}
