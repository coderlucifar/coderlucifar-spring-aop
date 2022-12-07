package com.coderlucifar.aop.bean;


public class UpdateOrderParam {
    private Long orderId;

    public UpdateOrderParam(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
