package com.axon.cqrs.controller;


import com.axon.cqrs.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {


    @PostMapping("")
    public CompletableFuture<?> createEmployee(@RequestBody Employee employee) {

        return null;
    }

}
