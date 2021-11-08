package com.backslashwelsh.myquery.service;

import com.backslashwelsh.myquery.model.store.Order;
import com.backslashwelsh.myquery.model.store.OrderItem;
import com.backslashwelsh.myquery.model.store.Product;
import com.backslashwelsh.myquery.repository.OrderItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    public void add(int orderId, OrderItem item) {
        Optional<Order> order = repository.findOrderById(orderId);
        order.ifPresent(value -> item.getOrderItemId().setOrderId(value));
        repository.save(item);
    }

    public List<OrderItem> findAll() {
        return repository.findAll();
    }

    public List<OrderItem> findAllByOrderId(int id) {
        return repository.findAllByOrderId(id);
    }


}
