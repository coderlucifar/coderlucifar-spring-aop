package com.coderlucifar.aop.log.entity;


public class OperateLog {

    private Long orderId;

    private String description;

    private String result;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OperateLog{" +
                "orderId=" + orderId +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
