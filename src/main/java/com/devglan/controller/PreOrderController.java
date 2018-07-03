package com.devglan.controller;

import com.devglan.controller.exception.runtimeException.GeneralError;
import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.SqlEntity.PreOrder;
import com.devglan.service.PreOrderService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ccloa on 21/6/2018.
 */
@PublicApiController
public class PreOrderController {

    @Autowired
    private PreOrderService preOrderService;

    @RequestMapping(value = "/preOrder/add", method = RequestMethod.POST)
    public PreOrder addPreOrder(@RequestBody PreOrder preOrder) {
        System.out.print("requesting /preOrder/add ");
        System.out.print(" PreOrder object" + preOrder.toString());
        return preOrderService.add(preOrder);
    }

    @RequestMapping(value = "/preOrder/update", method = RequestMethod.POST)
    public PreOrder updateProduct(@RequestBody PreOrder preOrder) {
        System.out.print("requesting /updateUser ");
        System.out.print(" User object" + preOrder.toString());

        PreOrder preOrderInstance = preOrderService.findById(preOrder.getId());
        if (preOrderInstance == null) {
            throw new GeneralError("pre-order id is invalid");
        }
        preOrder.setCreate_timestamp(preOrderInstance.getCreate_timestamp());
        preOrder.setLast_update_timestamp(TimeUtil.getCurrentTimeStamp());
        return preOrderService.update(preOrder);
    }

    @RequestMapping(value = "/preOrders", method = RequestMethod.GET)
    public List<PreOrder> listPreOrders() {
        return preOrderService.findAll();
    }


    //order id
    @RequestMapping(value = "/preOrder/{id}", method = RequestMethod.GET)
    public PreOrder getPreOrderById(@PathVariable(value = "id") Long id) {
        return preOrderService.findById(id);
    }

    //buyer id
    @RequestMapping(value = "/preOrder/{buyerId}", method = RequestMethod.GET)
    public List<PreOrder> getPreOrderByBuyerId(@PathVariable(value = "buyerId") Long id) {
        return preOrderService.findByBuyerId(id);
    }

    //product id
    @RequestMapping(value = "/preOrder/{productId}", method = RequestMethod.GET)
    public List<PreOrder> getPreOrderByProductId(@PathVariable(value = "productId") Long id) {
        return preOrderService.findByProductId(id);
    }

    // buyer name
    @RequestMapping(value = "/preOrder/findByBuyerName", method = RequestMethod.POST)
    public List<PreOrder> findByBuyerName(@RequestParam(value = "buyerName", required = true) String buyerName) {
        System.out.println("request path/  /preOrder/findByBuyerName");
        System.out.println("productName " + buyerName);
        return preOrderService.findByBuyerName(buyerName);
    }

    // product name
    @RequestMapping(value = "/preOrder/findByProductName", method = RequestMethod.POST)
    public List<PreOrder> findByProductName(@RequestParam(value = "productName", required = true) String productName) {
        System.out.println("request path/  /preOrder/findByProductName");
        System.out.println("productName " + productName);
        return preOrderService.findByProductName(productName);
    }


    @RequestMapping(value = "/preOrder/delete", method = RequestMethod.GET)
    public void deleteProduct(@RequestBody PreOrder product) {
        preOrderService.delete(product.getId());
    }

}
