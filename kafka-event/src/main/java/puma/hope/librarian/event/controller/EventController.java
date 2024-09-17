package puma.hope.librarian.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puma.hope.librarian.event.model.Event;
import puma.hope.librarian.event.service.EventService;

import java.util.List;

@RestController
@Tag(name = "Events", description = "Requests for users")
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/feed")
public class EventController {
    @Autowired
    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get event history for user by user ID")
    public List<Event> findAll(@PathVariable("userId") @Positive Long userId) {
        return eventService.getFeed(userId);
    }


}
