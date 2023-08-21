package com.moon.fc.project.core;

import com.moon.fc.project.core.domain.Engagement;
import com.moon.fc.project.core.domain.Event;
import com.moon.fc.project.core.domain.RequestStatus;
import com.moon.fc.project.core.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User writer = new User("writer", "email@email.com", "pw", LocalDate.now(), LocalDateTime.now());
        final User attendee = new User("attendee", "email@email.com", "pw", LocalDate.now(), LocalDateTime.now());
        final Event event = new Event(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "title",
                "description",
                writer,
                LocalDateTime.now()
        );

        event.addEngagement(new Engagement(event, attendee, LocalDateTime.now(), RequestStatus.REQUESTED));

        Assertions.assertEquals(event.getEngagements().get(0).getEvent().getWriter().getName(), "writer");
    }
}
