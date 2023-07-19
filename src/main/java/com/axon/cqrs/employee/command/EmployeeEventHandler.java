package com.axon.cqrs.employee.command;


import com.axon.cqrs.employee.entity.Employee;
import com.axon.cqrs.employee.repository.EmployeeRepository;
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
