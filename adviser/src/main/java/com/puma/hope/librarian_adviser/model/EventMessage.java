package com.puma.hope.librarian_adviser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventMessage {
    private Long userId;
    private Long targetId;
    private EventOperation operation;
    private EventEntityType type;
}