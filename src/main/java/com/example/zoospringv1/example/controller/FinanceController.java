package com.example.zoospringv1.example.controller;

import com.example.zoospringv1.example.service.FinanceService;
import com.example.zoospringv1.example.dto.MonthReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// pakiet controller


// PbF - package by feature (w notion pewnie jest o tym)

// enpoint aplikacji, punkt wejsciowy, IO - input/output, http/REST
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping("/month-report/{year}/{month}")
    public MonthReportDto getMonthReport(String year, String month) {
        // 0 logiki w kontrolerze
        return financeService.getMonthReport(year, month);
    }
    
}
