

package puma.hope.librarian_users.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import puma.hope.librarian_users.model.MessageDto;

@Component
public class KafkaConsumer {


    @KafkaListener(topics = "string-topic", containerFactory = "kafkaStringListenerContainerFactory", groupId = "my-group-id")
    public void listenString(String message) {
        System.out.println("Received message: " + message);
    }


    @KafkaListener(topics = "dto-topic", containerFactory = "kafkaListenerContainerFactory", groupId = "my-group-id")
    public void listen(MessageDto message) {
        System.out.println("Received DTO: " + message);
        System.out.println("Object message = " + message.getMessage());
    }


}

