package com.mq.application.sender;


import com.mq.application.config.RabbitConfig;
import com.mq.application.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Fanout 模式
 * 生产者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user) {
        //第一个参数：Exchange名字
        //第二个参数：Route-Key
        //第三个参数：要发送的内容
        amqpTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"",user);
    }

}
