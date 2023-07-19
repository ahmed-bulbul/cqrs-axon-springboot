package com.axon.cqrs.employee.query;

import lombok.Data;

import java.util.UUID;


@Data
public class GetEmployeeByIdQuery {

    private UUID id;
}
