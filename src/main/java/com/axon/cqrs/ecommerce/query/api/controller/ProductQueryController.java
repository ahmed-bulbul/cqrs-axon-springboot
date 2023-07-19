package com.axon.cqrs.ecommerce.query.api.controller;


import com.axon.cqrs.ecommerce.command.api.model.ProductRestModel;
import com.axon.cqrs.ecommerce.query.api.queries.GetProductsQuery;
import com.axon.cqrs.ecommerce.query.api.queries.GetProductsQueryById;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts(){
        GetProductsQuery getProductsQuery =
                new GetProductsQuery();

        List<ProductRestModel> productsRestModels = queryGateway.query(getProductsQuery,
                ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productsRestModels;
    }

    @GetMapping("/{id}")
    public ProductRestModel getProducts(@PathVariable(value = "id") String id){
        GetProductsQueryById getProductsQueryById =
                new GetProductsQueryById();
        getProductsQueryById.setId(id);

        return   queryGateway.query(getProductsQueryById,
               ResponseTypes.instanceOf(ProductRestModel.class)).join();
    }


}
