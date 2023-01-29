package com.example.zoospringv1.employee;

import com.example.zoospringv1.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<EmployeeDto> get() {
        return mapper.getEmployeesDto();
    }

    @GetMapping("/archive")
    public List<EmployeeDto> getArchived() {
        return mapper.getArchivedEmployeesDto();
    }

    @GetMapping("/{id}")
    public EmployeeDto get(@PathVariable("id") Integer id) {
        return mapper.getEmployeeByIdDto(id);
    }

    @DeleteMapping("/{id}")
    public void archive(@PathVariable("id") Integer id) {mapper.archiveEmployeeByIdDto(id);
    }

    @PostMapping
    public EmployeeDto add(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "familyName") String familyName,
            @RequestParam(value = "pesel") long pesel) {
        return mapper.toEmployee(new EmployeeCreateDto(firstName, familyName, pesel));
    }

}

