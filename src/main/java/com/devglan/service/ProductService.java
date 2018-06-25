package com.devglan.service;

import com.devglan.model.User;
import com.devglan.model.product.Product;

import java.util.List;

public interface ProductService {

    Product add(Product user);
    List<Product> findAll();
    void delete(long id);
    Product findById(Long id);
    Product update(Product user);
}
