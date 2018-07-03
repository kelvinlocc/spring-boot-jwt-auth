package com.devglan.service;

import com.devglan.model.product.pre_order;

import java.util.List;

public interface OrderService {

    pre_order add(pre_order user);
    List<pre_order> findAll();
    void delete(long id);
    pre_order findById(Long id);
    pre_order update(pre_order user);
    List<pre_order> findByBuyerId(Long BuyerId);
    List<pre_order> findByBuyerName(String buyerName);
    List<pre_order> findByProductId(Long ProductId);
    List<pre_order> findByProductName(String productName);
}
