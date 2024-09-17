package puma.hope.librarian.event.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events", schema = "librarian")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventId;
    @Column(name = "TIMESTAMP")
    Long timestamp;
    @Column(name = "USER_ID")
    Long userId;
    @Column(name = "ENTITY_ID")
    Long entityId;
    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION")
    EventOperation operation;
    @Enumerated(EnumType.STRING)
    @Column(name = "EVENT_ENTITY_TYPE")
    EventEntityType eventEntityType;

    public Event(Long timestamp, Long userId, Long entityId, EventOperation operation, EventEntityType eventEntityType) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.entityId = entityId;
        this.operation = operation;
        this.eventEntityType = eventEntityType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                ", entityId=" + entityId +
                ", operation=" + operation +
                ", eventEntityType=" + eventEntityType +
                '}';
    }
}