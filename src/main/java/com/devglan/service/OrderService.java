package com.devglan.service;

import com.devglan.model.product.Product;

import java.util.List;

public interface OrderService {

    Product add(Product user);
    List<Product> findAll();
    void delete(long id);
    Product findById(Long id);
    Product update(Product user);
    List<Product> findByBuyerName(String buyerName);
    List<Product> findByBuyerId(Long BuyerId);
}
