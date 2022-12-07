package com.coderlucifar.aop.bean;


public class SaveOrderParam {

    private Long id;

    public SaveOrderParam(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
