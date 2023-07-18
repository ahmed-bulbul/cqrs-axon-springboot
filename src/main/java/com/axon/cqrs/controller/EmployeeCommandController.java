package com.axon.cqrs.controller;


import com.axon.cqrs.command.CreateEmployeeCommand;
import com.axon.cqrs.entity.Employee;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("")
    public CompletableFuture<?> createEmployee(@RequestBody Employee employee) {

        CreateEmployeeCommand command = new CreateEmployeeCommand();

        command.setId(UUID.randomUUID());
        command.setName(employee.getName());
        command.setAge(employee.getAge());

        return commandGateway.send(command);
    }

}
