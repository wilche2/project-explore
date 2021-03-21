package com.xuexiangban.rabbitmq.springbootrabbitmqconsumer.utils;

/**
 * @author caoweiquan
 * @date 2021/3/20 21:36
 */
public class RabbitMqConstants {

    public static final String EXCHANGE_NAME_ORDER_FANOUT = "fanout_order_exchange";
    public static final String QUEUE_NAME_EMAIL_FANOUT = "email.fanout.queue";
    public static final String QUEUE_NAME_SMS_FANOUT = "sms.fanout.queue";
    public static final String QUEUE_NAME_WECHAT_FANOUT = "weChat.fanout.queue";

    public static final String EXCHANGE_NAME_ORDER_DIRECT = "direct_order_exchange";
    public static final String QUEUE_NAME_EMAIL_DIRECT = "email.direct.queue";
    public static final String QUEUE_NAME_SMS_DIRECT = "sms.direct.queue";
    public static final String QUEUE_NAME_WECHAT_DIRECT = "weChat.direct.queue";

    public static final String EXCHANGE_NAME_ORDER_TOPIC = "topic_order_exchange";
    public static final String QUEUE_NAME_EMAIL_TOPIC = "email.topic.queue";
    public static final String QUEUE_NAME_SMS_TOPIC = "sms.topic.queue";
    public static final String QUEUE_NAME_WECHAT_TOPIC = "weChat.topic.queue";

}
