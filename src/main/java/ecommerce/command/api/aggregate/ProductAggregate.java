package ecommerce.command.api.aggregate;


import ecommerce.command.api.commands.CreateProductCommand;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregate(CreateProductCommand createProductCommand) {

        //You can perform all the validation here
    }

    public ProductAggregate() {
    }
}
