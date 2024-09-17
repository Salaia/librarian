
package puma.hope.librarian_users.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import puma.hope.librarian_users.model.EventMessage;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaStringTemplate;

    public void sendMessage(String topic, String message) {
        kafkaStringTemplate.send(topic, message);
    }

    @Autowired
    private KafkaTemplate<String, EventMessage> kafkaEventTemplate;

    public void sendEventMessage(String topic, EventMessage message) {
        kafkaEventTemplate.send(topic, message);
    }

}



