package com.mq.application.receiver;

import com.mq.application.config.RabbitConfig;
import com.mq.application.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Direct 模式
 * 消费者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class DirectReceiver {

    //queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect1(User user){
        System.out.println("[receiveDirect1] receive message"+user);
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE2)
    public void receiveDirect2(User user){
        System.out.println("[receiveDirect2] receive message"+user);
    }

}
