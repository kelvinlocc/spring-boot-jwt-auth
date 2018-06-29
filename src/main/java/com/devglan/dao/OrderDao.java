package com.devglan.dao;

import com.devglan.model.User;
import com.devglan.model.product.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<User, Long> {
    Order findByOrderId(Long id);

    
}
