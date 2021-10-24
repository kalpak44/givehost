package com.givehost.web.repository;

import com.givehost.web.model.Order;
import com.givehost.web.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUser(User user);
}