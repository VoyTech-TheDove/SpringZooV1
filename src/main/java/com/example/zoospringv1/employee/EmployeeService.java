package com.example.zoospringv1.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private static AtomicLong COUNTER = new AtomicLong();

    public Employee addEmployeeRequest(String firstName, String familyName, long pesel) {
        Employee employee = createEmployee(firstName, familyName, pesel);
        addEmployeeToList(employee);
        return employee;
    }

    public void archiveEmployeeRequest(int id) {
        Employee employee = getEmployeeById(id);
        archiveEmployee(employee);
    }

    private void addEmployeeToList(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        List<Employee> actualEmployees = new ArrayList<>();
        for (Employee a : employees) {
            if (a.archived() == false) {
                actualEmployees.add(a);
            }
        }
        return actualEmployees;
    }

    private static Employee createEmployee(String firstName, String familyName, long pesel) {
        return new Employee(getNextId(), firstName, familyName, pesel, false);
    }

    private void archiveEmployee(Employee employee) {
        employees.add(new Employee(
                employee.id(), employee.firstName(), employee.familyName(),
                employee.pesel(), true));
        employees.remove(employee);
    }

    public List<Employee> getArchivedEmployees() {
        List<Employee> archivedEmployees = new ArrayList<>();
        for (Employee a : employees) {
            if (a.archived() == true) {
                archivedEmployees.add(a);
            }
        }
        return archivedEmployees;
    }

    private static int getNextId() {
        return (int) COUNTER.incrementAndGet();
    }

    public Employee getEmployeeById(int id) {
        for (Employee a : employees) {
            if (id == a.id()) {
                return a;
            }
        }
        return null;
    }
}