package com.axon.cqrs.employee.query.handler;


import com.axon.cqrs.employee.entity.Employee;
import com.axon.cqrs.employee.query.GetEmployeeByIdQuery;
import com.axon.cqrs.employee.repository.EmployeeRepository;
import com.axon.cqrs.employee.query.GetAllEmployeeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeQueryHandler {

    @Autowired
    private EmployeeRepository employeeRepository;



    @QueryHandler
    List<Employee> getAllEmployees(GetAllEmployeeQuery query) {
        return employeeRepository.findAll();
    }


    @QueryHandler
    public Employee getEmployeeById(GetEmployeeByIdQuery query) {
        return employeeRepository.findById(query.getId()).orElseThrow(()-> new RuntimeException("Employee not found"));
    }
}
