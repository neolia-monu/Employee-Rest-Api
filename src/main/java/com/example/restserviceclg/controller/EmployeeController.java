package com.example.restserviceclg.controller;

import com.example.restserviceclg.model.Employee;
import com.example.restserviceclg.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String index(){
        return "Welcome to the Employee Service Rest Service";
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/gender/{G}")
    public List<Employee> getEmployeeByGender(@PathVariable("G") Character gender){
        return employeeService.getEmployeeByGender(gender);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        Employee emp = employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully\n " + emp.toString(), HttpStatus.OK);
    }
}
