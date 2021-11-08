package com.backslashwelsh.myquery.model.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @DateTimeFormat
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PROCESSED'")
    private OrderStatus status = OrderStatus.PROCESSED;

    @Column(length = 1_000)
    private String comments;

    @DateTimeFormat
    private LocalDate shippedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    private Shipper shipperId;

    @OneToMany(mappedBy = "orderItemId.orderId", fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems;

}
