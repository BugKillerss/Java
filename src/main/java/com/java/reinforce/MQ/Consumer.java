package com.java.reinforce.MQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private static final String QUEUE_NAME = "my_queue";//队列名称
    private static final String EXCHANGR_NAME = "my_exchange";
    private static final String EXCHANGE_TYPE = "topic";
    private static final String EXCHANGE_ROUNTING_KEY = "my_rounting_key.#";

    public static void receive() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");//设置rabbitmq-server的地址
        connectionFactory.setPort(8080); //使用端口号
        connectionFactory.setVirtualHost("/");

        //由连接工创建连接
        Connection connection = connectionFactory.newConnection();

        //由连接创建通道
        Channel channel = connection.createChannel();

        //通过信道声明一个exchange，若存在则直接使用，不存在会自动创建
        //参数： name、type、是否支持持久化、拍他的、是否是是否支持自动删除、其他参数、
        channel.exchangeDeclare(EXCHANGR_NAME, EXCHANGE_TYPE, true, false, false, null);

        //通过信道声明一个queue，如果此队列已存在，则直接使用，不存在，会自动创建。
        //参数： name、type、是否支持持久化、拍他的、是否是是否支持自动删除、其他参数、
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //将queue绑定至某格exchange。一个exchange可以绑定多个queue。
        channel.queueBind(QUEUE_NAME, EXCHANGR_NAME, EXCHANGE_ROUNTING_KEY);

        //创建消费者，指定要使用的channel
        DefaultConsumer comsumer = new DefaultConsumer(channel) {
            //监听的queue中有消息进来时，会自动调用此方法来处理消息。但此方法默认是空的，需要重写
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("received message:" + message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, comsumer);

    }
}
