package com.example.zoospringv1.ticketOffice;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

interface TicketOfficeRepository {

    List<TicketOffice> findAll();
    List<TicketOffice> findByDone(@Param("state") boolean done);
    Optional<TicketOffice> findById(final int id);
    boolean existsById(Integer id);

    TicketOffice save(TicketOffice entity);

}
