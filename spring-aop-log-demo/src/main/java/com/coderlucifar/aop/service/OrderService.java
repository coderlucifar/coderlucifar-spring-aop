package com.coderlucifar.aop.service;


import com.coderlucifar.aop.bean.SaveOrderParam;
import com.coderlucifar.aop.bean.UpdateOrderParam;
import com.coderlucifar.aop.log.annotation.RecordOperate;
import com.coderlucifar.aop.log.SaveOrderParamConvert;
import com.coderlucifar.aop.log.UpdateOrderParamConvert;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @RecordOperate(desc = "保存", convert = SaveOrderParamConvert.class)
    public Boolean saveOrder(SaveOrderParam saveOrderParam) {
        System.out.println("saveOrder..., orderId: " + saveOrderParam.getId());
        return true;
    }

    @RecordOperate(desc = "更新", convert = UpdateOrderParamConvert.class)
    public Boolean updateOrder(UpdateOrderParam updateOrderParam) {
        System.out.println("updateOrder..., orderId: " + updateOrderParam.getOrderId());
        return true;
    }

}
