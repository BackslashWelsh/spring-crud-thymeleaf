package com.backslashwelsh.myquery.model.store;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @DateTimeFormat // fixme: 06.11.2021 check. do you need time?
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PROCESSED'")
//    private OrderStatus status; // fixme: check enum
    private OrderStatus status = OrderStatus.PROCESSED; // fixme: check enum

    @Column(length = 1000)
    private String comments;

    @DateTimeFormat // TODO: check
    private LocalDate shippedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    private Shipper shipperId;

    @OneToMany(mappedBy = "orderItemId.orderId", fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_item")
    private Set<OrderItem> orderItems;

}
