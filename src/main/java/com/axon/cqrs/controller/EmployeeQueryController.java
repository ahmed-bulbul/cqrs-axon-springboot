package com.axon.cqrs.controller;


import com.axon.cqrs.entity.Employee;
import com.axon.cqrs.query.GetAllEmployeeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {


    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Employee> findAll() {

        GetAllEmployeeQuery getAllEmpQuery = new GetAllEmployeeQuery();

        return queryGateway.query(getAllEmpQuery, ResponseTypes.multipleInstancesOf(Employee.class)).join();
    }

}
