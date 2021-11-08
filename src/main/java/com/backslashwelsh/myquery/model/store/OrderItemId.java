package com.backslashwelsh.myquery.model.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orderId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;
}
