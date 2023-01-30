package com.example.zoospringv1;

import com.example.zoospringv1.animal.Animal;
import com.example.zoospringv1.animal.AnimalDto;
import com.example.zoospringv1.animal.AnimalService;
import com.example.zoospringv1.employee.Employee;
import com.example.zoospringv1.employee.EmployeeCreateDto;
import com.example.zoospringv1.employee.EmployeeDto;
import com.example.zoospringv1.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {
    @Autowired
    AnimalService animalService;
    @Autowired
    EmployeeService employeeService;
    public AnimalDto toDto(Animal animal) {
        String name = animal.name();
        String species = animal.species();
        return new AnimalDto(species, name);
    }
    public EmployeeDto toDto(Employee employee) {
        int id = employee.id();
        String firstName = employee.firstName();
        String familyName = employee.familyName();
        return new EmployeeDto(id, firstName, familyName);
    }
    public AnimalDto toAnimal(AnimalDto animalDto) {
        return toDto(animalService.addAnimalRequested(animalDto.species(), animalDto.name()));
    }
    public EmployeeDto toEmployee(EmployeeCreateDto employeeDto) {
        return toDto(employeeService.addEmployeeRequest(employeeDto.firstName(), employeeDto.familyName(),employeeDto.pesel()));
    }
    public AnimalDto getAnimalByIdDto(int id) {
        return toDto(animalService.getAnimalById(id));
    }
    public EmployeeDto getEmployeeByIdDto(int id) {
        return toDto(employeeService.getEmployeeById(id));
    }
    public void archiveEmployeeByIdDto(int id) {
        employeeService.archiveEmployeeRequest(id);
    }
    public List<AnimalDto> getAnimalsDto() {
        List<AnimalDto> animalsDto = new ArrayList<>();
        List<Animal> animals = animalService.getAnimals();
        for (Animal a : animals) {
            animalsDto.add(toDto(a));
        }
        return animalsDto;
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