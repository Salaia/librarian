package puma.hope.librarian.event.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import puma.hope.librarian.event.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {


    List<Event> findAllByUserId(Long userId);

}
