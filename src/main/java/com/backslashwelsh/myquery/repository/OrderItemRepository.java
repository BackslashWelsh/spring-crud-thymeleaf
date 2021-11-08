package com.backslashwelsh.myquery.repository;

import com.backslashwelsh.myquery.model.store.Order;
import com.backslashwelsh.myquery.model.store.OrderItem;
import com.backslashwelsh.myquery.model.store.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
//    @Query(value = "SELECT IF (count(*) > 0, 'true', 'false') "
//            + "FROM order_items WHERE product_id = :id", nativeQuery = true)

    @Query("SELECT oi FROM OrderItem oi WHERE " +
            "oi.orderItemId.orderId.id = :id")
    List<OrderItem> findAllByOrderId(int id);

    @Query("SELECT o FROM Order o WHERE " +
            "o.id = :id")
    Optional<Order> findOrderById(int id);
}
