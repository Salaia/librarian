

package puma.hope.librarian.event.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import puma.hope.librarian.event.model.EventMessage;
import puma.hope.librarian.event.service.EventService;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final EventService eventService;

    @KafkaListener(topics = "string-topic", containerFactory = "kafkaStringListenerContainerFactory", groupId = "my-group-id")
    public void listenString(String message) {
        System.out.println("Received message: " + message);
    }


    @KafkaListener(topics = "event-topic", containerFactory = "kafkaEventListenerContainerFactory", groupId = "my-group-id")
    public void listen(EventMessage eventMessage) {
        System.out.println("Kafka listens to events");
        eventService.createEvent(eventMessage);

    }



}

