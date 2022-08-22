package com.example.restserviceclg.service;

import com.example.restserviceclg.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> getEmployeeByGender(Character gender);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);
}
