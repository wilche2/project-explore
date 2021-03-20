package com.xuexiangban.rabbitmq.springbootrabbitmqproducer;

import com.xuexiangban.rabbitmq.springbootrabbitmqproducer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootRabbitmqProducerApplicationTests {

    @Resource
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder(1L, 1L, 12);
    }

}
