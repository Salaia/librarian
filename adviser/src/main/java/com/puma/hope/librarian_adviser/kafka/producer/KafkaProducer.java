
package com.puma.hope.librarian_adviser.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.puma.hope.librarian_adviser.model.MessageDto;
import puma.hope.librarian_users.model.EventMessage;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, EventMessage> kafkaEventTemplate;

    public void sendEventMessage(String topic, EventMessage message) {
        kafkaEventTemplate.send(topic, message);
    }

}



