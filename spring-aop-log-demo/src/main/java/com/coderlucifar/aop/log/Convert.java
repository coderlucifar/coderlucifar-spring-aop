package com.coderlucifar.aop.log;


import com.coderlucifar.aop.log.entity.OperateLog;

public interface Convert<Param> {
    OperateLog convert(Param param);
}
