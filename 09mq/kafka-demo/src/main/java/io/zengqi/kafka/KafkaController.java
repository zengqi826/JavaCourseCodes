package io.zengqi.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * KafkaController
 *
 * @author zengqi
 * @date 2021/9/15 10:50
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {
    @Autowired
    private ProducerDemo producer;

    @RequestMapping("send")
    public String sendMessage(@RequestParam String message) {
        producer.send(message);
        return "发送成功";
    }
}