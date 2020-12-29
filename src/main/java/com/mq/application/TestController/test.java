package com.mq.application.TestController;

import com.mq.application.entity.User;
import com.mq.application.sender.DirectSender;
import com.mq.application.sender.FanoutSender;
import com.mq.application.sender.HeaderSender;
import com.mq.application.sender.TopicSender;
import com.mq.application.util.RestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * postman测试rabbitmq接口
 */
@RestController
public class test {

    @Resource
    private FanoutSender fanoutSender;

    @Resource
    private DirectSender directSender;

    @Resource
    private TopicSender topicSender;

    @Resource
    private HeaderSender headerSender;

    @GetMapping("/testFanoutSend")
    public RestResult testFanoutSend(User user,RestResult result){
        try{
            fanoutSender.send(user);
            result.setSuccess(true);
            result.setData("发送成功");
        }catch (Exception e){
            result.setSuccess(false);
            result.setErrorMessage("发送失败");
        }
        return result;
    }

    @GetMapping("/testDirectSend")
    public RestResult testDirectSend(User user,RestResult result){
        directSender.send(user);
        result.setSuccess(true);
        result.setData("发送成功");
        return result;
    }

    @GetMapping("/testTopicSend")
    public RestResult testTopicSend(User user,RestResult result){
        topicSender.send(user);
        result.setSuccess(true);
        result.setData("发送成功");
        return result;
    }

    @GetMapping("/testHeaderSend")
    public RestResult testHeaderSend(User user,RestResult result){
        headerSender.send("hello header Exchange");
        result.setSuccess(true);
        result.setData("发送成功");
        return result;
    }


}
