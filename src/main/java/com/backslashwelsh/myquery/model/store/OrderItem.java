package com.backslashwelsh.myquery.model.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @EmbeddedId
    private OrderItemId orderItemId;

    @NotNull
    @Min(1)
    private Integer quantity;

    @Transient
    private float subtotal;

    public float getSubtotal() {
        float unround = quantity * orderItemId.getProductId().getUnitPrice();
        return Math.round(unround * 100) / 100.0f;

    }
}
