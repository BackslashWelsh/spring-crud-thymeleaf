package com.backslashwelsh.myquery.repository;

import com.backslashwelsh.myquery.model.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT IF (count(*) > 0, 'true', 'false') "
            + "FROM order_items WHERE product_id = :id", nativeQuery = true)
    boolean isDependsOnOrderItem(@Param("id") int id);
}
