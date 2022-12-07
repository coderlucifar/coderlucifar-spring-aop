package com.coderlucifar.aop.log;

import com.coderlucifar.aop.bean.UpdateOrderParam;
import com.coderlucifar.aop.log.entity.OperateLog;


public class UpdateOrderParamConvert implements Convert<UpdateOrderParam> {
    @Override
    public OperateLog convert(UpdateOrderParam updateOrderParam) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(updateOrderParam.getOrderId());
        return operateLog;
    }
}
