package com.example.restserviceclg.service.implementation;

import com.example.restserviceclg.exception.ResourceNotFoundException;
import com.example.restserviceclg.model.Employee;
import com.example.restserviceclg.repository.EmployeeRepository;
import com.example.restserviceclg.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeeByGender(Character gender) {
        return employeeRepository.findByGender(gender);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setGender(employee.getGender());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
