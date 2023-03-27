package com.example.zoospringv1.example.repository;

import com.example.zoospringv1.example.model.FinanceEvent;
import com.example.zoospringv1.example.model.FinanceEventType;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// pakiet repository

// repozytorium zapewnia dane i zapisuje zmiany
// @Repository pobieranie danych 99,9999% z bazy danych
@Component
public class FinanceRepository {

    @Getter
    private final List<FinanceEvent> events = new ArrayList<>();

    public FinanceRepository() {
        events.addAll(List.of(
                new FinanceEvent(FinanceEventType.EARNING, BigDecimal.valueOf(105.12)),
                new FinanceEvent(FinanceEventType.COST, BigDecimal.valueOf(10))));
    }

}
