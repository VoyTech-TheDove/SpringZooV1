package com.example.zoospringv1.example;

import com.example.zoospringv1.example.dto.MonthReportDto;
import com.example.zoospringv1.example.repository.FinanceRepository;
import com.example.zoospringv1.example.service.FinanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

class FinanceServiceTest {

    // TODO wojtek
    // co to znaczy mock
    // biblioteka junit
    // biblioteka mockito
    private FinanceRepository financeRepository = Mockito.mock(FinanceRepository.class);

    private FinanceService financeService = new FinanceService(financeRepository);

    @Test
    public void shouldReturnZeroReportForNotExistingEvents() {
        // given
        Mockito.when(financeRepository.getEvents()).thenReturn(List.of());
        // when
        MonthReportDto monthReportDto = financeService.getMonthReport(null, null);
        // then
        Assertions.assertEquals(BigDecimal.ZERO, monthReportDto.getValue());
    }

}