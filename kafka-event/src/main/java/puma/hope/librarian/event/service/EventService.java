package puma.hope.librarian.event.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import puma.hope.librarian.event.exceptions.EntityNotFoundException;
import puma.hope.librarian.event.model.Event;
import puma.hope.librarian.event.model.EventMessage;
import puma.hope.librarian.event.storage.EventRepository;
import puma.hope.librarian.event.storage.UserJPARepository;

import java.time.Instant;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventService {

    EventRepository eventRepository;
    UserJPARepository userJPARepository;

    public void createEvent(EventMessage eventMessage) {
        Event event = new Event(Instant.now().toEpochMilli(), eventMessage.getUserId(),
                eventMessage.getTargetId(), eventMessage.getOperation(), eventMessage.getType());
        eventRepository.save(event);
        System.out.println("Saving event: " + event);
    }

    public List<Event> getFeed(Long userId) {
        if (!userJPARepository.existsById(userId)) throw new EntityNotFoundException("Not found: user by ID " + userId);
        return eventRepository.findAllByUserId(userId);
    }

}