package io.zengqi.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ConsumerDemo
 *
 * @author zengqi
 * @date 2021/9/15 10:45
 */

@Component
@Slf4j
public class ConsumerDemo {
    @KafkaListener(topics = ProducerDemo.TOPIC_TEST, groupId = ProducerDemo.TOPIC_GROUP1)
    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment ack,
                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test 消费了： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }
}