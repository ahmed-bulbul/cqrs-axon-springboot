package com.axon.cqrs.query;

import lombok.Data;

import java.util.UUID;


@Data
public class GetEmployeeByIdQuery {

    private UUID id;
}
