package com.mq.application.sender;

import com.mq.application.config.RabbitConfig;
import com.mq.application.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Direct 模式
 * 生产者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class DirectSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user){
        amqpTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE,"goods.update",user);
        //amqpTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE,"goods.delete",user);
    }

}
