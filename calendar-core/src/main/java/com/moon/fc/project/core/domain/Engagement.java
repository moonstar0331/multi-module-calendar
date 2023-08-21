package com.moon.fc.project.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Engagement {

    private Long id;
    private Event event;
    private User attendee;
    private LocalDateTime created;
    private RequestStatus requestStatus;

    public Engagement(Event event, User attendee, LocalDateTime created, RequestStatus requestStatus) {
        this.event = event;
        this.attendee = attendee;
        this.created = created;
        this.requestStatus = requestStatus;
    }
}
