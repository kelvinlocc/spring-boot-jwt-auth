package com.devglan.dao;

import com.devglan.model.product.pre_order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<pre_order, Long> {

    @Query(value = "SELECT * FROM pre_order WHERE buyer_id=:#{#buyerId}", nativeQuery = true)
    List<pre_order> findByBuyerId(@Param("buyerId") Long buyerId);

    @Query(value = "SELECT * FROM pre_order WHERE proudct_id=:#{#productId}", nativeQuery = true)
    List<pre_order> findByProductId(@Param("productId") Long productId);

}
