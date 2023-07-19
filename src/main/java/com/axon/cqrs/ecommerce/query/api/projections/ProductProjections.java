package com.axon.cqrs.ecommerce.query.api.projections;


import com.axon.cqrs.ecommerce.command.api.data.Product;
import com.axon.cqrs.ecommerce.command.api.data.ProductRepository;
import com.axon.cqrs.ecommerce.command.api.model.ProductRestModel;
import com.axon.cqrs.ecommerce.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjections {

    private final ProductRepository productRepository;

    public ProductProjections(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery){
        List<Product> products =
                productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .toList();

        return productRestModels;
    }
}
