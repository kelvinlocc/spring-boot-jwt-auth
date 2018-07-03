package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.OrderDao;
import com.devglan.dao.ProductDao;
import com.devglan.dao.UserDao;
import com.devglan.model.user;
import com.devglan.model.product.pre_order;
import com.devglan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;
    @Override
    public pre_order add(pre_order preorder) {
        return orderDao.save(preorder);
    }

    public List<pre_order> findAll() {
        List<pre_order> list = new ArrayList<>();
        orderDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        orderDao.delete(id);
    }

    @Override
    public pre_order findById(Long id) {
        return orderDao.findOne(id);
    }


    @Override
    public pre_order update(pre_order preorder) {
        pre_order preorderInstance = findById(preorder.getId());
        if (preorderInstance == null) {
            throw new UserInputError("invalid preorder id");
        }
        preorder.setCreate_timestamp(preorderInstance.getCreate_timestamp());
        return orderDao.save(preorder);
    }

    @Override
    public List<pre_order> findByBuyerName(String buyerName) {
        user userInstance = userDao.findByUsername(buyerName);
        if (userInstance == null) {
            throw new UserInputError("invalid input value");
        }

        return orderDao.findByBuyerId(userInstance.getId());
    }

    @Override
    public List<pre_order> findByBuyerId(Long buyerId) {
        return orderDao.findByBuyerId(buyerId);
    }

    @Override
    public List<pre_order> findByProductId(Long ProductId) {
        return orderDao.findByProductId(ProductId);
    }

    @Override
    public List<pre_order> findByProductName(String productName) {
        List<pre_order> productInstance = findByProductName(productName);
        if (productInstance == null) {

        }
//        return ord;
        return null;
    }


}
