package com.axon.cqrs.ecommerce.command.api.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;


@Entity
@Builder
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

}
