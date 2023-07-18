package com.axon.cqrs.command;

import lombok.Data;

import java.util.UUID;


@Data
public class CreateEmployeeEvent {

    private UUID id;

    private String name;

    private Integer age;
}
