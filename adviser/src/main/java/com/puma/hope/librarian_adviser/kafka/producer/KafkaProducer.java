
package com.puma.hope.librarian_adviser.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.puma.hope.librarian_adviser.model.MessageDto;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaStringTemplate;

    public void sendMessage(String topic, String message) {
        kafkaStringTemplate.send(topic, message);
    }

    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaDtoTemplate;

    public void sendMessageDTO(String topic, MessageDto message) {
        kafkaDtoTemplate.send(topic, message);
    }

}



