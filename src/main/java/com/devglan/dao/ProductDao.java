package com.devglan.dao;

import com.devglan.model.product.product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<product, Long> {
    product findById(Long id);

    @Query(value = "SELECT * FROM product WHERE category=:#{#cate}", nativeQuery = true)
    List<product> findByCategory(@Param("cate") String cate);

    //    @Query(value = "SELECT * FROM product WHERE category=:#{#cate}", nativeQuery = true)
//    product findByProductName(String product_name);
}
