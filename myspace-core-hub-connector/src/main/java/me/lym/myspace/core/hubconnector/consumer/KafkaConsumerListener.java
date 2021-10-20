package me.lym.myspace.core.hubconnector.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "new_resource_publish")
    public void onResourcePublish(String key, String value) {
        System.out.println("KafkaConsumerListener.onResourcePublish");
        System.out.println("key = " + key + ", value = " + value);
    }
}
