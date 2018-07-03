package com.devglan.dao;

import com.devglan.model.SqlEntity.PreOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreOrderDao extends CrudRepository<PreOrder, Long> {

    @Query(value = "SELECT * FROM PreOrder WHERE buyer_id=:#{#buyerId}", nativeQuery = true)
    List<PreOrder> findByBuyerId(@Param("buyerId") Long buyerId);

    @Query(value = "SELECT * FROM PreOrder WHERE proudct_id=:#{#productId}", nativeQuery = true)
    List<PreOrder> findByProductId(@Param("productId") Long productId);

}
