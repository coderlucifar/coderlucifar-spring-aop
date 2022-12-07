package com.coderlucifar.aop;

import com.coderlucifar.aop.bean.SaveOrderParam;
import com.coderlucifar.aop.bean.UpdateOrderParam;
import com.coderlucifar.aop.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @Resource
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        orderService.saveOrder(new SaveOrderParam(1L));
        orderService.updateOrder(new UpdateOrderParam(2L));
    }
}
