package com.example.zoospringv1.example.service;

import com.example.zoospringv1.example.dto.MonthReportDto;
import com.example.zoospringv1.example.model.FinanceEvent;
import com.example.zoospringv1.example.model.FinanceEventType;
import com.example.zoospringv1.example.repository.FinanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

// pakiet service

// odpowiada za logikę aplikacji - za przetwarzanie danych
@Service
@AllArgsConstructor
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    public MonthReportDto getMonthReport(String year, String month) {
        List<FinanceEvent> events = financeRepository.getEvents();
        return new MonthReportDto(
                sumEvents(events, FinanceEventType.EARNING)
                        .subtract(sumEvents(events, FinanceEventType.COST))
        );
    }

    // TODO wojtek
    // lambda
    // method reference ::
    // stream api
    // optional api (.orElse(BigDecimal.ZERO))
    // BigDecimal
    private BigDecimal sumEvents(List<FinanceEvent> events, FinanceEventType financeEventType) {
        return events.stream()
                .filter(event -> financeEventType.equals(event.getType()))
                .map(FinanceEvent::getValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
