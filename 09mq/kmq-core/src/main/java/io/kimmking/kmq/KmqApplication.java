package io.kimmking.kmq;

import io.kimmking.kmq.core.KmqBroker;
import io.kimmking.kmq.core.KmqConsumer;
import io.kimmking.kmq.core.KmqMessage;
import io.kimmking.kmq.core.KmqProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class KmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(KmqApplication.class, args);
        String topic = "kk.test";
        KmqBroker broker = new KmqBroker();
        broker.createTopic(topic);

        KmqProducer producer = broker.createProducer();
        KmqMessage<String> message1 = new KmqMessage<>(new HashMap<>(), "message1");
        KmqMessage<String> message2 = new KmqMessage<>(new HashMap<>(), "message2");
        producer.send(topic, message1);
        producer.send(topic, message2);

        KmqConsumer consumer = broker.createConsumer();
        consumer.subscribe(topic);
        System.out.println(consumer.readMessage().getBody());
        System.out.println(consumer.readMessage().getBody());
        consumer.commit();
        System.out.println(consumer.readMessage().getBody());

        KmqConsumer consumer2 = broker.createConsumer();
        consumer2.subscribe(topic);
        System.out.println(consumer2.readMessage().getBody());
        System.out.println(consumer2.readMessage().getBody());
        consumer2.commit();
        System.out.println(consumer2.readMessage().getBody());
    }

}
