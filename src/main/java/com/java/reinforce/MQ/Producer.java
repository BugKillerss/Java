package com.java.reinforce.MQ;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
     private static final String QUEUE_NAME = "my_queue";//��������
     private static final String EXCHANGR_NAME  ="my_exchange";
     private static final String EXCHANGE_TYPE ="topic";
     private static final String EXCHANGE_ROUNTING_KEY = "my_rounting_key.#";

     public static void send() throws IOException, TimeoutException{
         //�������ӹ���
         ConnectionFactory connectionFactory= new ConnectionFactory();
         connectionFactory.setHost("127.0.0.1");//����rabbitmq-server�ĵ�ַ
         connectionFactory.setPort(8080); //ʹ�ö˿ں�
         connectionFactory.setVirtualHost("/");

         //�����ӹ���������
         Connection connection= connectionFactory.newConnection();

         //�����Ӵ���ͨ��
         Channel channel = connection.createChannel();

         //ͨ���ŵ�����һ��exchange����������ֱ��ʹ�ã������ڻ��Զ�����
         //������ name��type���Ƿ�֧�ֳ־û��������ġ��Ƿ����Ƿ�֧���Զ�ɾ��������������
         channel.exchangeDeclare(EXCHANGR_NAME,EXCHANGE_TYPE,true,false,false,null);

         //ͨ���ŵ�����һ��queue������˶����Ѵ��ڣ���ֱ��ʹ�ã������ڣ����Զ�������
         //������ name��type���Ƿ�֧�ֳ־û��������ġ��Ƿ����Ƿ�֧���Զ�ɾ��������������
         channel.queueDeclare(QUEUE_NAME,true,false,false,null);

         //��queue����ĳ��exchange��һ��exchange���԰󶨶��queue��
         channel.queueBind(QUEUE_NAME,EXCHANGR_NAME,EXCHANGE_ROUNTING_KEY);


         //������Ϣ
         String msg = "Hello MyRabbitMq !";
         String routing_key = "my_routing_key.key1";
         channel.basicPublish(EXCHANGR_NAME,routing_key,null,msg.getBytes());//��Ϣ��byte[]���Դ�����������.
         System.out.println("send message:"+msg);

         //�ر�����
         connection.close();
         channel.close();
     }
}
