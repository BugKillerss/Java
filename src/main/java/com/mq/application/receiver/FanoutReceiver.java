package com.mq.application.receiver;

import com.mq.application.config.RabbitConfig;
import com.mq.application.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Fanout模式
 * 消费者
 *
 * @author BaiLiJun  on 2019/10/30
 */
@Component
public class FanoutReceiver {

    //queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveFanout1(User user){
        System.out.println("[receiveFanout1] receive message"+user);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveFanout2(User user){
        System.out.println("[receiveFanout2] receive message"+user);
    }

}
