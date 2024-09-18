
package com.puma.hope.librarian_adviser.kafka.producer;

import com.puma.hope.librarian_adviser.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, EventMessage> kafkaEventTemplate;

    public void sendEventMessage(String topic, EventMessage message) {
        kafkaEventTemplate.send(topic, message);
    }

}



