package com.java.reinforce.MQ;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
     private static final String QUEUE_NAME = "my_queue";//队列名称
     private static final String EXCHANGR_NAME  ="my_exchange";
     private static final String EXCHANGE_TYPE ="topic";
     private static final String EXCHANGE_ROUNTING_KEY = "my_rounting_key.#";

     public static void send() throws IOException, TimeoutException{
         //创建连接工厂
         ConnectionFactory connectionFactory= new ConnectionFactory();
         connectionFactory.setHost("127.0.0.1");//设置rabbitmq-server的地址
         connectionFactory.setPort(8080); //使用端口号
         connectionFactory.setVirtualHost("/");

         //由连接工创建连接
         Connection connection= connectionFactory.newConnection();

         //由连接创建通道
         Channel channel = connection.createChannel();

         //通过信道声明一个exchange，若存在则直接使用，不存在会自动创建
         //参数： name、type、是否支持持久化、拍他的、是否是是否支持自动删除、其他参数、
         channel.exchangeDeclare(EXCHANGR_NAME,EXCHANGE_TYPE,true,false,false,null);

         //通过信道声明一个queue，如果此队列已存在，则直接使用，不存在，会自动创建。
         //参数： name、type、是否支持持久化、拍他的、是否是是否支持自动删除、其他参数、
         channel.queueDeclare(QUEUE_NAME,true,false,false,null);

         //将queue绑定至某格exchange。一个exchange可以绑定多个queue。
         channel.queueBind(QUEUE_NAME,EXCHANGR_NAME,EXCHANGE_ROUNTING_KEY);


         //发送消息
         String msg = "Hello MyRabbitMq !";
         String routing_key = "my_routing_key.key1";
         channel.basicPublish(EXCHANGR_NAME,routing_key,null,msg.getBytes());//消息是byte[]可以传递所有类型.
         System.out.println("send message:"+msg);

         //关闭连接
         connection.close();
         channel.close();
     }
}
