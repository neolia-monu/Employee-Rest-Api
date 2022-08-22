package com.example.restserviceclg.repository;

import com.example.restserviceclg.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByGender(Character gender);
}
