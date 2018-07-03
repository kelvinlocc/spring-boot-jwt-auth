package com.devglan.service.impl;



import com.devglan.controller.exception.runtimeException.GeneralError;
import com.devglan.controller.exception.runtimeException.ServerInternalError;
import com.devglan.dao.ProductDao;
import com.devglan.model.SqlEntity.Product;
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
    public Product findByProductName(String productName) {
        System.out.print("findByProductName:    productName:"+productName);
        return productDao.findByProductName(productName);
    }


    @Override
    public Product add(Product product) {
        if (isDuplicated(product)) {
            throw new ServerInternalError("Product id is duplicated " + product.getId());
        }
        product.setCreate_timestamp(TimeUtil.getCurrentTimeStamp());
        product.setUpdate_timestamp(TimeUtil.getCurrentTimeStamp());
        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {

        Product productInstance = productDao.findById(product.getId());
        if (productInstance == null) {
            throw new GeneralError("invalid productId");
        }
        // check Product id
        product.setUpdate_timestamp(TimeUtil.getCurrentTimeStamp());
        return productDao.save(product);
    }

    @Override
    public List<Product> findByCategory(String cate) {
        return productDao.findByCategory(cate);
    }

    private boolean isDuplicated(Product product) {
        return findById(product.getId()) != null;
    }
}
