package io.kimmking.kmq.core;

public class KmqProducer<T> {

    private KmqBroker broker;

    public KmqProducer(KmqBroker broker) {
        this.broker = broker;
    }

    public void send(String topic, KmqMessage<T> message) {
        Kmq kmq = this.broker.findKmq(topic);
        if (null == kmq) {
            throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        }
        kmq.send(message);
    }
}
