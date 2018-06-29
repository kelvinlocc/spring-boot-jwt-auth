package com.devglan.service;

import com.devglan.model.product.Order;
import com.devglan.model.product.Product;

import java.util.List;

public interface OrderService {

    Order add(Order user);
    List<Order> findAll();
    void delete(long id);
    Order findById(Long id);
    Order update(Order user);
    List<Order> findByBuyerId(Long BuyerId);
    List<Order> findByBuyerName(String buyerName);
    List<Order> findByProductId(Long ProductId);
    List<Order> findByProductName(String productName);
}
