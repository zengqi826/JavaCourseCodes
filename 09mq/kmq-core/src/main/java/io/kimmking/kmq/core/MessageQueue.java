package io.kimmking.kmq.core;

/**
 * MessageQueue
 *
 * @author zengqi
 * @date 2021/9/15 11:05
 */
public class MessageQueue {

    private KmqMessage[] mqMessages;
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        this.mqMessages = new KmqMessage[capacity];
    }

    public <T> void write(KmqMessage<T> mqMessage, int offset) {
        if (offset == capacity) {
            throw new RuntimeException("the queue message is full，can not accept more");
        }
        mqMessages[offset] = mqMessage;
    }

    public <T> KmqMessage<T> read(int offset) {
        return mqMessages[offset];
    }
}
