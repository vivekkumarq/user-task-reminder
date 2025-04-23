package com.neko.serviceImpl;

import com.neko.dto.NotificationDto;
import com.neko.entity.Notification;
import com.neko.exceptions.ErrorCode.ErrorCode;
import com.neko.exceptions.UserTaskReminderException;
import com.neko.repositories.NotificationRepository;
import com.neko.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public NotificationDto create(NotificationDto notification) {
        notification.setId(UUID.randomUUID());
        notification.setCreatedDate(LocalDateTime.now());
        Notification saved = notificationRepository.save(mapper.map(notification, Notification.class));
        return mapper.map(saved, NotificationDto.class);
    }

    @Override
    public NotificationDto getById(UUID id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.NOTIFICATION_NOT_FOUND, id));
        return mapper.map(notification, NotificationDto.class);
    }

    @Override
    public List<NotificationDto> get() {
        return notificationRepository.findAll().stream()
                .map(notification -> mapper.map(notification, NotificationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto update(UUID id, NotificationDto notification) {
        Notification existingNotification = notificationRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.NOTIFICATION_NOT_FOUND, id));

        for (Field field : notification.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(notification);
                if (Objects.nonNull(value)) {
                    Field entityField = existingNotification.getClass().getDeclaredField(field.getName());
                    entityField.setAccessible(true);
                    entityField.set(existingNotification, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        Notification saved = notificationRepository.save(existingNotification);
        return mapper.map(saved, NotificationDto.class);
    }

    @Override
    public void delete(UUID id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.NOTIFICATION_NOT_FOUND, id));
        notificationRepository.delete(notification);
    }
}
