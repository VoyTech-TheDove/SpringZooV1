package com.example.zoospringv1.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    @Autowired
    EmployeeService employeeService;

    public EmployeeDto toDto(Employee employee) {
        int id = employee.id();
        String firstName = employee.firstName();
        String familyName = employee.familyName();
        return new EmployeeDto(id, firstName, familyName);
    }

    public EmployeeDto toEmployee(EmployeeCreateDto employeeDto) {
        return toDto(employeeService.addEmployeeRequest(employeeDto.firstName(), employeeDto.familyName(), employeeDto.pesel()));
    }

    public EmployeeDto getEmployeeByIdDto(int id) {
        return toDto(employeeService.getEmployeeById(id));
    }

    public void archiveEmployeeByIdDto(int id) {
        employeeService.archiveEmployeeRequest(id);
    }

    public List<EmployeeDto> getEmployeesDto() {
        List<EmployeeDto> employeesDto = new ArrayList<>();
        List<Employee> employees = employeeService.getEmployees();
        for (Employee a : employees) {
            employeesDto.add(toDto(a));
        }
        return employeesDto;
    }

    public List<EmployeeDto> getArchivedEmployeesDto() {
        List<EmployeeDto> employeesDto = new ArrayList<>();
        List<Employee> employees = employeeService.getArchivedEmployees();
        for (Employee a : employees) {
            employeesDto.add(toDto(a));
        }
        return employeesDto;
    }
}
