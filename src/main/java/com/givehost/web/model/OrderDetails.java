package com.givehost.web.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String key;
    private String value;

    public Long getId() {
        return id;
    }

    public OrderDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public String getKey() {
        return key;
    }

    public OrderDetails setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public OrderDetails setValue(String value) {
        this.value = value;
        return this;
    }
}
