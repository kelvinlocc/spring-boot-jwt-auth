package com.devglan.service;

import com.devglan.model.SqlEntity.PreOrder;

import java.util.List;

public interface PreOrderService {

    PreOrder add(PreOrder preOrder);
    List<PreOrder> findAll();
    void delete(long id);
    PreOrder findById(Long id);
    PreOrder update(PreOrder preOrder);
    List<PreOrder> findByBuyerId(Long BuyerId);
    List<PreOrder> findByBuyerName(String buyerName);
    List<PreOrder> findByProductId(Long ProductId);
    List<PreOrder> findByProductName(String productName);
}
