package com.axon.cqrs.query.handler;


import com.axon.cqrs.entity.Employee;
import com.axon.cqrs.query.GetAllEmployeeQuery;
import com.axon.cqrs.query.GetEmployeeByIdQuery;
import com.axon.cqrs.repository.EmployeeRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
