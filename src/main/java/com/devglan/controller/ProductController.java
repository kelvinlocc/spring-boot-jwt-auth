package com.devglan.controller;

import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.product.product;
import com.devglan.service.ProductService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by ccloa on 21/6/2018.
 */
@PublicApiController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public product saveUser(@RequestBody product product) {
        System.out.print("requesting /signUp ");
        System.out.print(" user object" + product.toString());

        return productService.add(product);
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public product updateProduct(@RequestBody product product) {
        System.out.print("requesting /updateUser ");
        System.out.print(" user object" + product.toString());
        com.devglan.model.product.product productInstance = productService.findById(product.getId());
        if (productInstance == null) {
            throw new UserInputError("product id is invalid");
        }
        product.setCreate_time_stamp(productInstance.getCreate_time_stamp());
        product.setUpdate_time_stamp(TimeUtil.getCurrentTimeStamp());
        return productService.update(product);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<product> listProducts() {
        return productService.findAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public product getProductById(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public void deleteProduct(@RequestBody product product) {
        productService.delete(product.getId());
    }

    @RequestMapping(value = "/product/category/{cate}", method = RequestMethod.GET)
    public List<product> findyProductBycate(@PathVariable(value = "cate")String cate) {
        return productService.findByCategory(cate);
    }
}
