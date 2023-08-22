package com.moon.fc.project.api.service;

import com.moon.fc.project.api.dto.AuthUser;
import com.moon.fc.project.api.dto.TaskCreateReq;
import com.moon.fc.project.core.domain.entity.Schedule;
import com.moon.fc.project.core.domain.entity.repository.ScheduleRepository;
import com.moon.fc.project.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    public void create(TaskCreateReq taskCreateReq, AuthUser authUser) {
        final Schedule taskSchedule = Schedule.task(
                taskCreateReq.getTitle(),
                taskCreateReq.getDescription(),
                taskCreateReq.getTaskAt(),
                userService.findByUserId(authUser.getId())
        );

        scheduleRepository.save(taskSchedule);
    }
}
