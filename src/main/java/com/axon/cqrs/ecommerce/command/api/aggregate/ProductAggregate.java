package com.axon.cqrs.ecommerce.command.api.aggregate;


import com.axon.cqrs.ecommerce.command.api.commands.CreateProductCommand;
import com.axon.cqrs.ecommerce.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;


    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {

        //You can perform all validation

        ProductCreatedEvent productCreatedEvent =
                new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent); //published event
    }

    public ProductAggregate() {
    }


    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.quantity = productCreatedEvent.getQuantity();
        this.productId = productCreatedEvent.getProductId();
        this.price = productCreatedEvent.getPrice();
        this.name = productCreatedEvent.getName();
    }
}
