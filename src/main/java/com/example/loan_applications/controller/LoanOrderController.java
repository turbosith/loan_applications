package com.example.loan_applications.controller;

import com.example.loan_applications.dto.ApplicationSubmission;
import com.example.loan_applications.dto.LoanOrderSuccess;
import com.example.loan_applications.dto.TariffDTO;
import com.example.loan_applications.model.response.DataResponse;
import com.example.loan_applications.model.response.DataResponseTariff;
import com.example.loan_applications.model.response.DataResponseTariffById;
import com.example.loan_applications.service.LoanOrderService;
import com.example.loan_applications.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/loan-service")
public class LoanOrderController {
    private final TariffService tariffService;
    private final LoanOrderService loanOrderService;

    @GetMapping("/getTariffs")
    public ResponseEntity<DataResponse> getTariffs() {
        return ResponseEntity.ok(new DataResponse(new DataResponseTariff(tariffService.findAll())));
    }

    @PostMapping("/addTariff")
    public ResponseEntity<Integer> addTariff(@RequestBody TariffDTO tariffDTO) {
        return ResponseEntity.ok(tariffService.save(tariffDTO));
    }

    @GetMapping("/getTariff")
    public ResponseEntity<DataResponse> getTariff(@RequestParam long id) {
        return ResponseEntity.ok(new DataResponse(new DataResponseTariffById(tariffService.getById(id))));
    }
    @PostMapping ("/order")
    public ResponseEntity<DataResponse> newOrder(@RequestBody ApplicationSubmission applicationSubmission){
        return ResponseEntity.ok(new DataResponse(loanOrderService.add(applicationSubmission)));
    }
        @GetMapping("/getStatusOrder")
    public ResponseEntity<DataResponse> getStatus(@RequestParam String orderId) {
        return ResponseEntity.ok(new DataResponse(loanOrderService.getStatus(orderId)));
    }



/*
@DeleteMapping("/deleteOrder}")
    public String deleteOrder(Model model) {
        return "";
    }
    @PostMapping ("/order")
    public ResponseEntity<Integer> newOrder(@RequestBody ApplicationSubmission applicationSubmission){
        return ResponseEntity.ok(tariffService.save(tariffDTO));
    }
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
