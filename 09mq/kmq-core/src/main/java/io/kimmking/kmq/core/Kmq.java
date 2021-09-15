package io.kimmking.kmq.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Kmq {


    private String topic;
    private int capacity;
    private int offset;
    private Map<String, Integer> comsumerOffsetRecord;
    private MessageQueue messageQueue;

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        messageQueue = new MessageQueue(capacity);
        this.offset = 0;
        comsumerOffsetRecord = new ConcurrentHashMap<>();
    }
    public <T>  void send(KmqMessage<T> mqMessage) {
        messageQueue.write(mqMessage, this.offset);
        this.offset++;
    }

    public <T> KmqMessage<T> read(String consumerName) {
        Integer offset = comsumerOffsetRecord.getOrDefault(consumerName, 0);
        if (offset > this.offset) {
            throw new RuntimeException("the message offset now is :"  + this.offset + ",but you want to read " + offset);
        }
        return  messageQueue.read(offset);
    }

    public void commit(String consumerName) {
        comsumerOffsetRecord.putIfAbsent(consumerName, 1);
        comsumerOffsetRecord.computeIfPresent(consumerName, (s, v) -> v++);
    }

}
