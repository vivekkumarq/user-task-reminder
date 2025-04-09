package com.neko.service;

import com.neko.dto.NotificationDto;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto);

    List<NotificationDto> getAllNotifications();

    NotificationDto getNotificationById(UUID id);

    NotificationDto updateNotification(UUID id, NotificationDto notificationDto);

    void deleteNotification(UUID id);
}
