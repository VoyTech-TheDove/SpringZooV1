package com.example.zoospringv1.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private List<Employee> archivedEmployees = new ArrayList<>();
    private static AtomicLong COUNTER = new AtomicLong();
    public void addEmployeeToList(Employee employee){
        getEmployees().add(employee);
    }
    public List<Employee> getEmployees(){
        return employees;
    }
    public void addEmployeeToArchivedList(Employee employee){
        getArchivedEmployees().add(employee);
    }
    public List<Employee> getArchivedEmployees() {return archivedEmployees;}
    private static Employee createEmployee(String firstName,String familyName, long pesel) {
        return new Employee(getNextId(), firstName,familyName,pesel);
    }
    private static int getNextId() {
        return (int) COUNTER.incrementAndGet();
    }

    public Employee addEmployeeRequest (String firstName,String familyName, long pesel){
        Employee employee = createEmployee(firstName,familyName,pesel);
        addEmployeeToList(employee);
        return employee;
    }
    public void archiveEmployeeRequest (int id){
        Employee employee = getEmployeeById(id);
        addEmployeeToArchivedList(employee);
        deleteEmployeFromList(employee);
        }
    public boolean deleteEmployeFromList (Employee employee){
        for (Employee a : employees){
            if (employee.equals(a)) {
                employees.remove(a);
                return true;
            }
        }
        return false;
    }
    public Employee getEmployeeById (int id){
        for (Employee a : employees){
            if (id == a.id()) {
                return a;
            }
        }
        return null;
    }
}
