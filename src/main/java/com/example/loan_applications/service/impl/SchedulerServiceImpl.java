package com.example.loan_applications.service.impl;

import com.example.loan_applications.constants.StatusEnum;
import com.example.loan_applications.model.LoanOrder;
import com.example.loan_applications.repository.LoanOrderRepository;
import com.example.loan_applications.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@EnableAsync
@Component
public class SchedulerServiceImpl implements SchedulerService {
    private final LoanOrderRepository loanOrderRepository;

    /**
     * Метод рассмотрения заявок
     */
    @Override
    @Async
    @Scheduled(initialDelay = 1000 * 10, fixedRate = 1000 * 2 * 60)
    public void approvalApplications() {
        List<LoanOrder> loanOrders = loanOrderRepository.findByStatus(StatusEnum.IN_PROGRESS);
        for (LoanOrder loanOrder : loanOrders) {
            Boolean decision = new Random().nextBoolean();
            if (decision) {
                loanOrderRepository.updateLoanOrder(
                        StatusEnum.APPROVED,
                        new Timestamp(System.currentTimeMillis()),
                        loanOrder.getId());
            } else {
                loanOrderRepository.updateLoanOrder(
                        StatusEnum.REFUSED,
                        new Timestamp(System.currentTimeMillis()),
                        loanOrder.getId());
            }
        }
    }

}

