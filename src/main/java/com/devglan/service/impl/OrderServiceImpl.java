package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.ServerInternalError;
import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.OrderDao;
import com.devglan.dao.ProductDao;
import com.devglan.dao.UserDao;
import com.devglan.model.User;
import com.devglan.model.product.Order;
import com.devglan.service.OrderService;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public Order add(Order order) {
        return orderDao.save(order);
    }

    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        orderDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        orderDao.delete(id);
    }

    @Override
    public Order findById(Long id) {
        return orderDao.findOne(id);
    }


    @Override
    public Order update(Order order) {
        Order orderInstance = findById(order.getId());
        if (orderInstance == null) {
            throw new UserInputError("invalid order id");
        }
        order.setCreate_timestamp(orderInstance.getCreate_timestamp());
        return orderDao.save(order);
    }

    @Override
    public List<Order> findByBuyerName(String buyerName) {
        User userInstance = userDao.findByUsername(buyerName);
        if (userInstance == null) {
            throw new UserInputError("invalid input value");
        }

        return orderDao.findByBuyerId(userInstance.getId());
    }

    @Override
    public List<Order> findByBuyerId(Long buyerId) {
        return orderDao.findByBuyerId(buyerId);
    }

    @Override
    public List<Order> findByProductId(Long ProductId) {
        return orderDao.findByProductId(ProductId);
    }

    @Override
    public List<Order> findByProductName(String productName) {
        List<Order> productInstance = findByProductName(productName);
        if (productInstance == null) {

        }
//        return ord;
        return null;
    }


}
