package com.moon.fc.project.api.service;

import com.moon.fc.project.api.dto.AuthUser;
import com.moon.fc.project.api.dto.NotificationCreateReq;
import com.moon.fc.project.core.domain.entity.Schedule;
import com.moon.fc.project.core.domain.entity.User;
import com.moon.fc.project.core.domain.entity.repository.ScheduleRepository;
import com.moon.fc.project.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void create(NotificationCreateReq notificationCreateReq, AuthUser authUser) {
        final User user = userService.findByUserId(authUser.getId());
        final List<LocalDateTime> notifyAtList = notificationCreateReq.getRepeatTimes();
        notifyAtList.forEach(notifyAt -> {
            final Schedule notificationSchedule =
                    Schedule.notification(
                            notificationCreateReq.getTitle(),
                            notifyAt,
                            user);
            scheduleRepository.save(notificationSchedule);
        });
    }
}
