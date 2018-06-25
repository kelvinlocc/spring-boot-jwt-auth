package com.devglan.controller;

import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.LoginUser;
import com.devglan.model.User;
import com.devglan.model.UserToken;
import com.devglan.model.product.Product;
import com.devglan.service.ProductService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public Product saveUser(@RequestBody Product product) {
        System.out.print("requesting /signUp ");
        System.out.print(" User object" + product.toString());

        return productService.add(product);
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public Product updateUser(@RequestBody Product product) {
        System.out.print("requesting /updateUser ");
        System.out.print(" User object" + product.toString());

        return productService.update(product);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> listUser() {
        return productService.findAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getOne(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public void deleteProduct(@RequestBody Product product) {
        productService.delete(product.getId());
    }

}
