package com.mq.application.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.BindingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitConfig 配置类
 *
 * @author sunke  on 2020/8/10
 */
@Configuration
public class RabbitConfig {

    //topic 模式
    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";
    public static final String TOPIC_EXCHANGE = "topic.exchange";

    //fanout 模式
    public static final String FANOUT_QUEUE1 = "fandout.queue1";
    public static final String FANOUT_QUEUE2 = "fandout.queue2";
    public static final String FANOUT_EXCHANGE = "fandout.exchange";

    //direct模式
    public static final String DIRECT_QUEUE1 = "direct.queue1";
    public static final String DIRECT_QUEUE2 = "direct.queue2";
    public static final String DIRECT_EXCHANGE = "direct.exchange";

    //Headers 模式
    public static final String HEADER_QUEUE1 = "header.queue1";
    public static final String HEADER_QUEUE2 = "header.queue2";
    public static final String HEADER_EXCHANGE = "header.exchange";


    /**
     * topic 模式
     *
     */

    /**
     * 声明队列topicQueue1
     *
     * @return
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    /**
     * 声明队列topicQueue2
     *
     * @return
     */
    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }

    /**
     * 声明主题模式交换机 TopicExchange
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }


    /**
     * 将队列topicQueue1绑定到交换机
     *
     * @return
     */
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("user.add");
    }

    /**
     * 将队列topicQueue2绑定到交换机
     *
     * @return
     */
    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("user.#");
    }


    /**
     * fanout 模式
     *Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息
     */


    /**
     * 声明队列 fanoutQueue1
     *
     * @return
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE1);
    }

    /**
     * 声明队列 fanoutQueue2
     *
     * @return
     */
    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2);
    }

    /**
     * 声明FanoutExchange
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    /**
     * 将队列fanoutQueue1 绑定到交换机
     *
     * @return
     */
    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    /**
     * 将队列fanoutQueue2 绑定到交换机
     *
     * @return
     */
    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    /**
     * direct模式
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
     * @return
     */

    /**
     * 声明队列DIRECT_QUEUE1
     *
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE1);
    }

    /**
     * 声明队列DIRECT_QUEUE2
     *
     * @return
     */
    @Bean
    public Queue directQueue2() {
        return new Queue(DIRECT_QUEUE2);
    }

    /**
     * 声明directExchange
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    /**
     * 将队列1绑定到交换机
     * @return
     */
    @Bean
    public Binding directBinding1(){
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("goods.update");
    }

    /**
     * 将队列2绑定到交换机
     * @return
     */
    @Bean
    public Binding directBinding2(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("goods.delete");
    }


    /**
     * Headers 模式
     * 设置header attribute参数类型的交换机，相较于 direct 和 topic 固定地使用 routing_key ,
     * headers 则是一个自定义匹配规则的类型. 在队列与交换器绑定时, 会设定一组键值对规则,
     * 消息中也包括一组键值对( headers 属性), 当这些键值对有一对, 或全部匹配时, 消息被投送到对应队列
     *
     */

    @Bean
    public Queue headerQueue1(){
        return  new Queue(HEADER_QUEUE1,true);
    }

    @Bean
    public Queue headerQueue2(){
        return  new Queue(HEADER_QUEUE2,true);
    }

    @Bean
    public HeadersExchange headersExchange(){


        return new HeadersExchange(HEADER_EXCHANGE);
    }

    @Bean
    public Binding headerBinding1(){
        Map<String, Object> map = new HashMap<>();
        map.put("header1","value1");
        map.put("header2","value2");
        return BindingBuilder.bind(headerQueue1()).to(headersExchange()).whereAll(map).match();
    }

    @Bean
    public Binding headerBinding2(){
        Map<String, Object> map = new HashMap<>();
        map.put("header1","value1");
        map.put("header2","value2");
        return BindingBuilder.bind(headerQueue2()).to(headersExchange()).whereAll(map).match();
    }

}
