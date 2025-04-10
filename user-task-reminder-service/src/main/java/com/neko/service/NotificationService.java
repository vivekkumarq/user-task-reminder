package com.neko.service;

import com.neko.dto.NotificationDto;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationDto create(NotificationDto notificationDto);

    List<NotificationDto> get();

    NotificationDto getById(UUID id);

    NotificationDto update(UUID id, NotificationDto notificationDto);

    void delete(UUID id);
}
