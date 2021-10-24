package com.givehost.web.repository;

import com.givehost.web.model.Order;
import com.givehost.web.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {
}