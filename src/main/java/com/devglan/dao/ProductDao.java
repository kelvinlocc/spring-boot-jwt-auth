package com.devglan.dao;

import com.devglan.model.SqlEntity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
    Product findById(Long id);

    @Query(value = "SELECT * FROM Product WHERE category=:#{#cate}", nativeQuery = true)
    List<Product> findByCategory(@Param("cate") String cate);

    @Query(value = "SELECT * FROM Product WHERE product_name=:#{#product_name}", nativeQuery = true)
    Product findByProductName(@Param("product_name") String product_name);



}
