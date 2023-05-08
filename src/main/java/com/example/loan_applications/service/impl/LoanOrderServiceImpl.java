package com.example.loan_applications.service.impl;

import com.example.loan_applications.constants.StatusEnum;
import com.example.loan_applications.dto.ApplicationSubmission;
import com.example.loan_applications.dto.GetOrderStatusSuccess;
import com.example.loan_applications.dto.LoanOrderSuccess;
import com.example.loan_applications.exception.CustomException;
import com.example.loan_applications.model.LoanOrder;
import com.example.loan_applications.repository.LoanOrderRepository;
import com.example.loan_applications.repository.TariffRepository;
import com.example.loan_applications.service.LoanOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanOrderServiceImpl implements LoanOrderService {
    private final TariffRepository tariffRepository;
    private final LoanOrderRepository loanOrderRepository;

    @Override
    public LoanOrderSuccess add(ApplicationSubmission applicationSubmission) {
        if (tariffRepository.existsById(applicationSubmission.getTariffId())) {
           List<LoanOrder> loanOrders= loanOrderRepository.findByUserId(applicationSubmission.getUserId());
            for (LoanOrder loanOrder:loanOrders){
                if(loanOrder.getStatus()== StatusEnum.IN_PROGRESS)
                    throw new CustomException("LOAN_CONSIDERATION", "Уже существует заявка в процессе расмотрения");
                else if(loanOrder.getStatus()== StatusEnum.APPROVED){
                    throw new CustomException("LOAN_ALREADY_APPROVED", "Существует одобренная заявка");
                }
                else if(loanOrder.getStatus()== StatusEnum.REFUSED){
                    long presentTime = new Timestamp(System.currentTimeMillis()).getTime();
                    if(presentTime-loanOrder.getTimeUpdate().getTime()<1_000*2*60){
                        throw new CustomException("TRY_LATER", "Попробуйте позже");
                    }
                }


            }
            String orderid=UUID.randomUUID().toString();
            loanOrderRepository.save(new LoanOrder(
                    orderid ,
                    applicationSubmission.getUserId(),
                    applicationSubmission.getTariffId(),
                    Math.random()*0.8+0.1,
                    StatusEnum.IN_PROGRESS,
                    new Timestamp(System.currentTimeMillis())));
            return new LoanOrderSuccess(orderid);

        }
        else {
        throw new CustomException("TARIFF_NOT_FOUND", "Тариф не найден");}

    }

    @Override
    public GetOrderStatusSuccess getStatus(String orderId) {
        return new GetOrderStatusSuccess(loanOrderRepository.getStatusByOrderId(orderId).getStatus().toString());
    }
}
