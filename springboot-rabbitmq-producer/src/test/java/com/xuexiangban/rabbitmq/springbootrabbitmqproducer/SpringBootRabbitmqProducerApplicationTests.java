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

    @Test
    void testTopic() {
        orderService.makeOrderTopic(1L, 1L, 12);
    }

    @Test
    void makeOrderTopicConfirm() {
        orderService.makeOrderTopicConfirm("1", "", 12);
    }

    @Test
    public void testDirect() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            Long userId = 100L + i;
            Long productId = 10001L + i;
            int num = 10;
            orderService.makeOrderDirect(userId, productId, num);
        }
    }

    @Test
    void testTtl() {
        for (int i = 0; i < 11; i++) {
            orderService.makeOrderTtl(1L, 1L, 12);
        }
    }

    @Test
    void testMessageTtl() {
        orderService.makeOrderMessageTtl(1L, 1L, 12);
    }


}
