package com.devglan.service;

import com.devglan.model.product.product;

import java.util.List;

public interface ProductService {

    product add(product user);
    List<product> findAll();
    void delete(long id);
    product findById(Long id);
    product findByProductName(String productName);
    product update(product user);
    List<product> findByCategory(String cate);
}
