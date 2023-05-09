package com.example.loan_applications.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
/**
 * Конфигурация для релизации запланированного запуска джоба рассмотрения заявок
 */
public class SchedulerConfig {
}
