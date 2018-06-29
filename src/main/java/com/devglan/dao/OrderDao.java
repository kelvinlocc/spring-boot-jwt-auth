package com.devglan.dao;

import com.devglan.model.User;
import com.devglan.model.product.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {

    @Query(value = "SELECT * FROM Order WHERE buyer_id=:#{#buyerId}", nativeQuery = true)
    List<Order> findByBuyerId(@Param("buyerId") Long buyerId);

    @Query(value = "SELECT * FROM Order WHERE proudct_id=:#{#productId}", nativeQuery = true)
    List<Order> findByProductId(@Param("productId") Long productId);

}
