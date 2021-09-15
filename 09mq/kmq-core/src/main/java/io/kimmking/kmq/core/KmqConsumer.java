package io.kimmking.kmq.core;

import java.util.UUID;

public class KmqConsumer<T> {

    private final KmqBroker broker;
    private Kmq kmq;
    private String consumerName;

    public KmqConsumer(KmqBroker broker) {
        this.broker = broker;
        this.consumerName = UUID.randomUUID().toString();
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) {
            throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        }
    }

    public KmqMessage<T> readMessage() {
        return (KmqMessage<T>) kmq.read(this.consumerName);
    }

    public void commit() {
        kmq.commit(this.consumerName);
    }
}
