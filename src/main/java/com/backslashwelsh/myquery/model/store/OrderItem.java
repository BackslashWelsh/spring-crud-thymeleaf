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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

//fixme
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "order_id")
//    int id;

    //    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    Order orderId;
//
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    Product productId;
    @EmbeddedId
    private OrderItemId orderItemId;

    @Min(1)
    private int quantity;

    @Transient
    private float subtotal;

    public float getSubtotal() {
        float unround = quantity * orderItemId.getProductId().getUnitPrice();
        return Math.round(unround * 100) / 100.0f; // fixme use JavaScipt

    }


//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order_id;

}
