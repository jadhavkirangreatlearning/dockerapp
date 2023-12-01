package com.csi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {

    private int empId;

    private String empName;

    private double empSalary;


}

@RestController
@RequestMapping("/")
public class ApplicationController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello WELCOME TO FULL STACK JAVA DEVELOPER PUNE");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listOfEmployee() {
        return ResponseEntity.ok(Stream.of(new Employee(121, "SWARA", 65000),
                new Employee(122, "RAM", 95000),
                new Employee(123, "LAKSHMI", 75000),
                new Employee(124, "KUMAR", 65000),
                new Employee(125, "SWARAJ", 85000)).toList());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(Stream.of(new Employee(121, "SWARA", 65000),
                new Employee(122, "RAM", 95000),
                new Employee(123, "LAKSHMI", 75000),
                new Employee(124, "KUMAR", 65000),
                new Employee(125, "SWARAJ", 85000)).toList().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
    }

    //added api for sortbysalary
    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary() {
        return ResponseEntity.ok(Stream.of(new Employee(121, "SWARA", 65000),
                new Employee(122, "RAM", 95000),
                new Employee(123, "LAKSHMI", 75000),
                new Employee(124, "KUMAR", 65000),
                new Employee(125, "SWARAJ", 85000)).toList().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));
    }


}

