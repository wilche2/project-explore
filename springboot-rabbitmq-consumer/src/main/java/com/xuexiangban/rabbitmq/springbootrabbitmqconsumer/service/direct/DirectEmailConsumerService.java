package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils.RabbitMqConstants.QUEUE_NAME_EMAIL_DIRECT;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:59
 */
@RabbitListener(queues = QUEUE_NAME_EMAIL_DIRECT)
//@RabbitListener(bindings = @QueueBinding(
//        // email.fanout.queue 是队列名字，这个名字你可以自定随便定义。
//        value = @Queue(value = "email.fanout.queue", autoDelete = "false"),
//        // order.fanout 交换机的名字 必须和生产者保持一致
//        exchange = @Exchange(value = "fanout_order_exchange",
//                // 这里是确定的rabbitmq模式是：fanout 是以广播模式 、 发布订阅模式
//                type = ExchangeTypes.FANOUT)
//))
@Component
public class DirectEmailConsumerService {

    @RabbitHandler
    public void messageAccept(String message) {
        // 此处省略发邮件的逻辑
        System.out.println("DIRECT email--------------> " + message);
    }

}
