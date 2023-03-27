package com.example.zoospringv1.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

// pakiet model

@Getter
@RequiredArgsConstructor
public class FinanceEvent {

    // nie robimy powtórzeń w nazwach zmiennych
    private final FinanceEventType type;
    private final BigDecimal value;

}
