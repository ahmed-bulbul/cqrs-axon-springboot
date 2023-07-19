package com.axon.cqrs.employee.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@Setter
public class CreateEmployeeCommand {

    @TargetAggregateIdentifier
    private UUID id;

    private String name;

    private Integer age;
}
