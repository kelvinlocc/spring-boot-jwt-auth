package com.devglan.service;

import com.devglan.model.SqlEntity.PreOrder;

import java.util.List;

public interface OrderService {

    PreOrder add(PreOrder user);
    List<PreOrder> findAll();
    void delete(long id);
    PreOrder findById(Long id);
    PreOrder update(PreOrder user);
    List<PreOrder> findByBuyerId(Long BuyerId);
    List<PreOrder> findByBuyerName(String buyerName);
    List<PreOrder> findByProductId(Long ProductId);
    List<PreOrder> findByProductName(String productName);
}
