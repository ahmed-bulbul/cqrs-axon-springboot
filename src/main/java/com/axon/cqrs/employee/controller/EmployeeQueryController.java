package com.axon.cqrs.employee.controller;


import com.axon.cqrs.employee.entity.Employee;
import com.axon.cqrs.employee.query.GetAllEmployeeQuery;
import com.axon.cqrs.employee.query.GetEmployeeByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id")UUID id) {

        GetEmployeeByIdQuery getAllEmpQuery = new GetEmployeeByIdQuery();
        getAllEmpQuery.setId(id);

        return queryGateway.query(getAllEmpQuery, ResponseTypes.instanceOf(Employee.class)).join();
    }

}
