package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.GeneralError;
import com.devglan.dao.PreOrderDao;
import com.devglan.dao.ProductDao;
import com.devglan.dao.UserDao;
import com.devglan.model.SqlEntity.PreOrder;
import com.devglan.model.SqlEntity.Product;
import com.devglan.model.SqlEntity.User;
import com.devglan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service(value = "orderService")
public class PreOrderServiceImpl implements OrderService {

    @Autowired
    private PreOrderDao orderDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public PreOrder add(PreOrder preorder) {
        return orderDao.save(preorder);
    }

    public List<PreOrder> findAll() {
        List<PreOrder> list = new ArrayList<>();
        orderDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        orderDao.delete(id);
    }

    @Override
    public PreOrder findById(Long id) {
        return orderDao.findOne(id);
    }


    @Override
    public PreOrder update(PreOrder preorder) {
        PreOrder preorderInstance = findById(preorder.getId());
        if (preorderInstance == null) {
            throw new GeneralError("invalid preorder id");
        }
        preorder.setCreate_timestamp(preorderInstance.getCreate_timestamp());
        return orderDao.save(preorder);
    }

    @Override
    public List<PreOrder> findByBuyerName(String buyerName) {
        User userInstance = userDao.findByUsername(buyerName);
        if (userInstance == null) {
            throw new GeneralError("invalid input value");
        }

        return orderDao.findByBuyerId(userInstance.getId());
    }

    @Override
    public List<PreOrder> findByBuyerId(Long buyerId) {
        return orderDao.findByBuyerId(buyerId);
    }

    @Override
    public List<PreOrder> findByProductId(Long ProductId) {
        return orderDao.findByProductId(ProductId);
    }

    @Override
    public List<PreOrder> findByProductName(String productName) {
        Product productInstance = productDao.findByProductName(productName);
        if (productInstance == null) {
            throw new GeneralError("product name not found");


        } else if (findByProductId(productInstance.getId()).isEmpty()) {
            throw new GeneralError("this product name has no any pre-order");
        } else {
            return findByProductId(productInstance.getId());
        }
    }


}
