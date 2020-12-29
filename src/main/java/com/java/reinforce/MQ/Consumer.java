package com.java.reinforce.MQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private static final String QUEUE_NAME = "my_queue";//��������
    private static final String EXCHANGR_NAME = "my_exchange";
    private static final String EXCHANGE_TYPE = "topic";
    private static final String EXCHANGE_ROUNTING_KEY = "my_rounting_key.#";

    public static void receive() throws IOException, TimeoutException {
        //�������ӹ���
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");//����rabbitmq-server�ĵ�ַ
        connectionFactory.setPort(8080); //ʹ�ö˿ں�
        connectionFactory.setVirtualHost("/");

        //�����ӹ���������
        Connection connection = connectionFactory.newConnection();

        //�����Ӵ���ͨ��
        Channel channel = connection.createChannel();

        //ͨ���ŵ�����һ��exchange����������ֱ��ʹ�ã������ڻ��Զ�����
        //������ name��type���Ƿ�֧�ֳ־û��������ġ��Ƿ����Ƿ�֧���Զ�ɾ��������������
        channel.exchangeDeclare(EXCHANGR_NAME, EXCHANGE_TYPE, true, false, false, null);

        //ͨ���ŵ�����һ��queue������˶����Ѵ��ڣ���ֱ��ʹ�ã������ڣ����Զ�������
        //������ name��type���Ƿ�֧�ֳ־û��������ġ��Ƿ����Ƿ�֧���Զ�ɾ��������������
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //��queue����ĳ��exchange��һ��exchange���԰󶨶��queue��
        channel.queueBind(QUEUE_NAME, EXCHANGR_NAME, EXCHANGE_ROUNTING_KEY);

        //���������ߣ�ָ��Ҫʹ�õ�channel
        DefaultConsumer comsumer = new DefaultConsumer(channel) {
            //������queue������Ϣ����ʱ�����Զ����ô˷�����������Ϣ�����˷���Ĭ���ǿյģ���Ҫ��д
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("received message:" + message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, comsumer);

    }
}
