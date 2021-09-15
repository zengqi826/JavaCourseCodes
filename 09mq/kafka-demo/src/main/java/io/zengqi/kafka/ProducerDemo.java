package io.zengqi.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * ProducerDemo
 *
 * @author zengqi
 * @date 2021/9/15 10:40
 */
@Component
@Slf4j
public class ProducerDemo {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    //自定义topic
    public static final String TOPIC_TEST = "test32";
    public static final String TOPIC_GROUP1 = "group1";
    public void send(Object obj) {
        String obj2String = JSONObject.toJSONString(obj);
        log.info("准备发送消息为：{}", obj2String);
        //发送消息
        int partitionNum = 0;
        int hashCode = obj.hashCode();
        partitionNum = hashCode % 3;
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_TEST, partitionNum,
                String.valueOf(partitionNum), obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TOPIC_TEST + " - 生产者 发送消息失败：" + throwable.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(TOPIC_TEST + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });
    }
}
