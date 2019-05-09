package com.dek.pojo;

import java.io.Serializable;

public class Order implements Serializable {

    private String id;
    private String no;
    private String routingKey;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", no='" + no + '\'' +
                ", routingKey='" + routingKey + '\'' +
                '}';
    }
}
