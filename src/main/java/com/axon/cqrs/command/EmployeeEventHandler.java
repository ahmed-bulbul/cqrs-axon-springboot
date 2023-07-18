package com.axon.cqrs.command;


import com.axon.cqrs.entity.Employee;
import com.axon.cqrs.repository.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void createEmployee(CreateEmployeeEvent event) {

        Employee employee = new Employee();
        employee.setId(event.getId());
        employee.setName(event.getName());
        employee.setAge(event.getAge());

        employeeRepository.save(employee);

    }
}
