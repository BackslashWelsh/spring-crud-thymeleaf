package com.backslashwelsh.myquery.model.store;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Integer quantityInStock;

    @NotNull
    @Digits(integer = 4, fraction = 2)
    private Float unitPrice;
}
