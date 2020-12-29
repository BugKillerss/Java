package com.mq.application.sender;


import com.mq.application.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Headers 模式
 * 生产者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class HeaderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(Object massage) {
        //第一个参数：Exchange名字
        //第二个参数：Route-Key
        //第三个参数：要发送的内容
        String msg=(String)massage;
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1","value1");
        properties.setHeader("header2","value2");
        Message message = new Message(msg.getBytes(), properties);
        amqpTemplate.convertAndSend(RabbitConfig.HEADER_EXCHANGE,"",message);
    }

}
