package com.axon.cqrs.ecommerce.query.api.queries;

import lombok.Data;

import java.util.UUID;


@Data
public class GetProductsQueryById {

    private String id;
}
