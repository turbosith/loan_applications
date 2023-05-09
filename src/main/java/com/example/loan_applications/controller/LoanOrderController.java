package com.example.loan_applications.controller;

import com.example.loan_applications.dto.ApplicationSubmission;
import com.example.loan_applications.dto.DeleteOrder;
import com.example.loan_applications.dto.TariffDTO;
import com.example.loan_applications.exception.CustomException;
import com.example.loan_applications.model.response.DataResponse;
import com.example.loan_applications.model.response.DataResponseTariff;
import com.example.loan_applications.model.response.DataResponseTariffById;
import com.example.loan_applications.service.LoanOrderService;
import com.example.loan_applications.service.TariffService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/loan-service")

public class LoanOrderController {
    private final TariffService tariffService;
    private final LoanOrderService loanOrderService;
    public static final String COUNTER_CONTROLLER = "counterController";

    /**
     * Метод получения списка тарифов
     * @return - список тирифов
     */
    @GetMapping("/getTariffs")
    @CircuitBreaker(name = COUNTER_CONTROLLER, fallbackMethod = "fallBack")
    public ResponseEntity<DataResponse> getTariffs() {
        return ResponseEntity.ok(new DataResponse(new DataResponseTariff(tariffService.findAll())));
    }

    /**
     * Метод создания нового тарифа
     * @param tariffDTO - объект с параметрами будущего тарифа
     * @return - результат выполнения запроса
     */
    @PostMapping("/addTariff")
    public ResponseEntity<Integer> addTariff(@RequestBody TariffDTO tariffDTO) {
        return ResponseEntity.ok(tariffService.save(tariffDTO));
    }

    /**
     * Метод получения тарифа по id
     * @param id - идентификатор тарифа
     * @return - тариф с идентификатором id
     */
    @GetMapping("/getTariff")
    public ResponseEntity<DataResponse> getTariff(@RequestParam long id) {
        return ResponseEntity.ok(new DataResponse(new DataResponseTariffById(tariffService.getById(id))));
    }

    /**
     * Метод подачи заявки на кредит
     * @param applicationSubmission - объект подачи заявки на на кредит
     * @return - идентификатор заявки
     */
    @PostMapping("/order")
    public ResponseEntity<DataResponse> newOrder(@RequestBody ApplicationSubmission applicationSubmission) {
        return ResponseEntity.ok(new DataResponse(loanOrderService.add(applicationSubmission)));
    }

    /**
     * Метод получения статуса заявки
     * @param orderId - идентификатор заявки
     * @return - статус заявки
     */
    @GetMapping("/getStatusOrder")
    public ResponseEntity<DataResponse> getStatus(@RequestParam String orderId) {
        return ResponseEntity.ok(new DataResponse(loanOrderService.getStatus(orderId)));
    }

    /**
     * Метод удаления заявки
     * @param deleteOrder - объект удаления заявки
     */
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestBody DeleteOrder deleteOrder) {
        loanOrderService.delete(deleteOrder);
    }

    /**
     * метод, который должен срабатывать при задержке
     */
    public void fallBack() {
        log.info("Circuit breaker");
        throw new CustomException("RESPONSE_WAITING_TIME", "Превышено время ожидания ответа");
    }


}
