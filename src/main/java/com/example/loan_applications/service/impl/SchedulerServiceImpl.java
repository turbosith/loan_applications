package com.example.loan_applications.service.impl;

import com.example.loan_applications.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@EnableAsync
@Component
public class SchedulerServiceImpl implements SchedulerService {
    @Override
    @Async
    public void approvalApplications() {

    }
}
