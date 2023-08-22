package com.moon.fc.project.api.service;

import com.moon.fc.project.core.domain.entity.Engagement;

public interface EmailService {
    void sendEngagement(Engagement engagement);
}
