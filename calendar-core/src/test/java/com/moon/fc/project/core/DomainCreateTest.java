package com.moon.fc.project.core;

import com.moon.fc.project.core.domain.ScheduleType;
import com.moon.fc.project.core.domain.entity.Schedule;
import com.moon.fc.project.core.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User me = new User("meme", "email", "pw", LocalDate.now());
        final Schedule taskSchedule = Schedule.task("할일", "청소하기", LocalDateTime.now(), me);
        Assertions.assertEquals(taskSchedule.getScheduleType(), ScheduleType.TASK);
        Assertions.assertEquals(taskSchedule.toTask().getTitle(), "할일");
    }
}
