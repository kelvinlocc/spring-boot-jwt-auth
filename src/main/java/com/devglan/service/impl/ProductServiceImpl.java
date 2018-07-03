package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.ServerInternalError;
import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.ProductDao;
import com.devglan.model.product.product;
import com.devglan.service.ProductService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


@Service(value = "ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;



    public List<product> findAll() {
        List<product> list = new ArrayList<>();
        productDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        productDao.delete(id);
    }


    @Override
    public product findById(Long id) {
        return productDao.findOne(id);
    }

    @Override
    public product findByProductName(String productName) {
//        return productDao.findByProductName(productName);
        return null;
    }


    @Override
    public product add(product product) {
        if (isDuplicated(product)) {
            throw new ServerInternalError("product id is duplicated " + product.getId());
        }
        product.setCreate_time_stamp(TimeUtil.getCurrentTimeStamp());
        product.setUpdate_time_stamp(TimeUtil.getCurrentTimeStamp());
        return productDao.save(product);
    }

    @Override
    public product update(product product) {

        com.devglan.model.product.product productInstance = productDao.findById(product.getId());
        if (productInstance == null) {
            throw new UserInputError("invalid productId");
        }
        // check product id
        product.setUpdate_time_stamp(TimeUtil.getCurrentTimeStamp());
        return productDao.save(product);
    }

    @Override
    public List<product> findByCategory(String cate) {
        return productDao.findByCategory(cate);
    }

    private boolean isDuplicated(product product) {
        return findById(product.getId()) != null;
    }
}
