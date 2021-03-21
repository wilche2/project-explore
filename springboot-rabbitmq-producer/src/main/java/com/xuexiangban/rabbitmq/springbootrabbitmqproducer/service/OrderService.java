package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.service;

import com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils.RabbitMqConstants;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:33
 */
@Service
public class OrderService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(Long userId, Long productId, int num) {
        // 1： 模拟用户下单
        String orderNumer = UUID.randomUUID().toString();

        String routeKey = "";

        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        // 发送订单信息给RabbitMQ fanout
        // 参数1：交换机名称 参数2：routeKey/queueName 参数3：消息内容
        rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_NAME_ORDER_FANOUT, routeKey, orderNumer);
    }

    public void makeOrderDirect(Long userId, Long productId, int num) {
        // 1： 模拟用户下单
        String orderNumer = UUID.randomUUID().toString();

        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        // 发送订单信息给RabbitMQ fanout
        // 参数1：交换机名称 参数2：routeKey/queueName 参数3：消息内容
        rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_NAME_ORDER_DIRECT, "email", orderNumer);
        rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_NAME_ORDER_DIRECT, "sms", orderNumer);
    }

    public void makeOrderTopic(Long userId, Long productId, int num) {
        // 1： 模拟用户下单
        String orderNumer = UUID.randomUUID().toString();

        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        // 发送订单信息给RabbitMQ fanout
        String routingKey = "weChat.sms";
        // *.email.#
        // #.sms.#
        // weChat.#
        // 参数1：交换机名称 参数2：routeKey/queueName 参数3：消息内容
        rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_NAME_ORDER_TOPIC, routingKey, orderNumer);
    }

    public void makeOrderTtl(Long userId, Long productId, int num) {
        // 1： 模拟用户下单
        String orderNumer = UUID.randomUUID().toString();

        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        // 发送订单信息给RabbitMQ fanout
        String routingKey = "ttl-test";
        // 参数1：交换机名称 参数2：routeKey/queueName 参数3：消息内容
        rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_NAME_ORDER_TTL_DIRECT, routingKey, orderNumer);
    }

    public void makeOrderMessageTtl(Long userId, Long productId, int num) {
        // 1： 模拟用户下单
        String orderNumer = UUID.randomUUID().toString();

        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        // 发送订单信息给RabbitMQ fanout
        String routingKey = "ttl-message-test";
        // 构建消息体的自定义参数
        MessagePostProcessor messagePostProcessor = message -> {
            message.getMessageProperties().setExpiration("5000");
            message.getMessageProperties().setContentEncoding("UTF-8");
            return message;
        };

        // 参数1：交换机名称 参数2：routeKey/queueName 参数3：消息内容
        rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_NAME_ORDER_TTL_DIRECT, routingKey, orderNumer, messagePostProcessor);
    }


}
