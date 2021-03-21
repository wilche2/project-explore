package com.xuexiangban.rabbitmq.springbootrabbitmqproducer.utils;

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

    public static final String EXCHANGE_NAME_ORDER_TTL_DIRECT = "ttl_direct_exchange";
    public static final String QUEUE_NAME_TTL_DIRECT = "ttl.direct.queue";
    public static final String QUEUE_NAME_MESSAGE_TTL_DIRECT = "ttl.message.direct.queue";

    /**
     * 死信交换机和队列
     */
    public static final String EXCHANGE_NAME_ORDER_DEAD_DIRECT = "dead_direct_exchange";
    public static final String QUEUE_NAME_DEAD_DIRECT = "dead.direct.queue";

}
