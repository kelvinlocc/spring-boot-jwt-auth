package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.ServerInternalError;
import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.ProductDao;
import com.devglan.model.product.Product;
import com.devglan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


@Service(value = "Product")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        productDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        productDao.delete(id);
    }


    @Override
    public Product findById(Long id) {
        return productDao.findOne(id);
    }


    @Override
    public Product add(Product product) {
        if (isDuplicated(product)) {
            throw new ServerInternalError("product id is duplicated " + product.getId());
        }


        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {

        Product productInstance = productDao.findById(product.getId());
        if (productInstance == null) {
            throw new UserInputError("invalid productId");
        }
        // check product id
        return productDao.save(product);
    }

    private boolean isDuplicated(Product product) {
        return findById(product.getId()) != null;
    }
}
