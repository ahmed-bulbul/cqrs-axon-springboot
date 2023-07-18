package com.axon.cqrs.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;


@Aggregate
public class EmployeeAggregator {


    @AggregateIdentifier
    private UUID empId;

    private String name;

    private Integer age;

    @CommandHandler
    public EmployeeAggregator(CreateEmployeeCommand command) {

        CreateEmployeeEvent event = new CreateEmployeeEvent();
        event.setId(command.getId());
        event.setName(command.getName());
        event.setAge(command.getAge());

        //TODO : write business logic here

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateEmployeeEvent event) {
        this.empId = event.getId();
        this.name = event.getName();
        this.age = event.getAge();
    }

    public EmployeeAggregator() {
    }


}
