package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:36
 */
public class RabbitMqConstants {

    public static final String EXCHANGE_NAME_ORDER = "fanout_order_exchange";

    public static final String QUEUE_NAME_EMAIL = "email.fanout.queue";
    public static final String QUEUE_NAME_SMS = "sms.fanout.queue";
    public static final String QUEUE_NAME_WECHAT = "weChat.fanout.queue";

}
