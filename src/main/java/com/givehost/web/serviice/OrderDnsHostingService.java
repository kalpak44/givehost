package com.givehost.web.serviice;

import com.givehost.web.model.Order;
import com.givehost.web.model.OrderDetails;
import com.givehost.web.repository.OrderRepository;
import com.givehost.web.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderDnsHostingService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderDnsHostingService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public void doOrder(int domainsLimit) {
        final Order order = new Order();
        order.setUser(userRepository.findByEmail(getCurrentUserEmail()));
        order.setOrderDetails(new HashSet<>(toOrderDetails(domainsLimit)));
        orderRepository.save(order);
    }

    public List<Order> getMyOrders() {
        return orderRepository.findByUser(userRepository.findByEmail(getCurrentUserEmail()));
    }

    private String getCurrentUserEmail() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }


    private List<OrderDetails> toOrderDetails(Integer domainsLimit) {
        return Arrays.asList(new OrderDetails().setKey("orderType").setValue("DNS_HOSTING"),
                new OrderDetails().setKey("domainsLimit").setValue(domainsLimit.toString()));
    }
}
