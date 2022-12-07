package com.coderlucifar.aop.log;

import com.coderlucifar.aop.bean.SaveOrderParam;
import com.coderlucifar.aop.log.entity.OperateLog;


public class SaveOrderParamConvert implements Convert<SaveOrderParam> {
    @Override
    public OperateLog convert(SaveOrderParam saveOrderParam) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(saveOrderParam.getId());
        return operateLog;
    }
}
