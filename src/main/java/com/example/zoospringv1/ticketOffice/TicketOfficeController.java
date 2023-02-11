package com.example.zoospringv1.ticketOffice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
class TicketOfficeController {
    private static final Logger logger = LoggerFactory.getLogger(TicketOfficeController.class);
    private final TicketOfficeRepository repository;

    TicketOfficeController(final TicketOfficeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/ticketoffice")
    ResponseEntity<TicketOffice> createTask(@RequestBody @Validated TicketOffice toCreate) {
        TicketOffice result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("/ticketoffice/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Validated TicketOffice toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/ticketoffice", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<TicketOffice>> readAllTasks() {
        logger.warn("Exposing all!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/ticketoffice/{id}")
    ResponseEntity<TicketOffice> readTask(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
