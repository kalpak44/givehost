package com.givehost.web.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private OrderStatus orderStatus = OrderStatus.REQUESTED;
    private LocalDate created = LocalDate.now();
    @OneToMany(cascade=CascadeType.ALL)
    @NotNull
    private Set<OrderDetails> orderDetails = new HashSet<>();
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Order setCreated(LocalDate ordered) {
        this.created = ordered;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User orderedBy) {
        this.user = orderedBy;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }
}
