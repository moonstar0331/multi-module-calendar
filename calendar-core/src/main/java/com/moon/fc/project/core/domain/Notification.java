package com.moon.fc.project.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Notification {

    private Long id;
    private LocalDateTime notifyAt;
    private String title;
    private User writer;
    private LocalDateTime createdAt;

    public Notification(LocalDateTime notifyAt, String title, User writer, LocalDateTime createdAt) {
        this.notifyAt = notifyAt;
        this.title = title;
        this.writer = writer;
        this.createdAt = createdAt;
    }
}
