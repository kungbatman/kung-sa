package io.kung.shop.rocketmq.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Author kung
 * @Date 2023/3/9 10:52
 * @Version 1.0.0
 * @Description RocketMQ生产者
 */
public class RocketMQProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("kungProducerGroup");
        // 设置NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 启动生产者
        producer.start();
        // 构建消息对象
        Message message = new Message("kungTopic", "kungTag", "Hello RocketMQ".getBytes());
        System.out.println("生产者发出的消息是： " + JSONObject.toJSONString(message));
        // 发消息并接收结果
        SendResult sendResult = producer.send(message);
        // 打印结果消息
        System.out.println("生产者接收到的发送结果信息为： " + JSONObject.toJSONString(sendResult));
        // 关闭生产者
        producer.shutdown();

    }
}
