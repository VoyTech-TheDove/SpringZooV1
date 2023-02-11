package com.example.zoospringv1.ticketOffice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTicketOfficeRepository extends TicketOfficeRepository, JpaRepository<TicketOffice,Integer> {

}
