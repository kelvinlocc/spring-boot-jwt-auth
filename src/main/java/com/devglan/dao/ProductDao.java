package com.devglan.dao;

import com.devglan.model.User;
import com.devglan.model.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
    Product findById(Long id);
}
