package com.mq.application.receiver;

import com.mq.application.config.RabbitConfig;
import com.mq.application.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Topic 模式
 * 消费者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class TopicReceiver {

    //queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(User user){
        System.out.println("[receiveTopic1] receive message"+user.toString());
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(User user){
        System.out.println("[receiveTopic2] receive message"+user.toString());
    }

}
