package com.neko.serviceImpl;

import com.neko.dto.NotificationDto;
import com.neko.entity.Notification;
import com.neko.repositories.NotificationRepository;
import com.neko.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    public NotificationDto createNotification(NotificationDto dto) {
        dto.setId(UUID.randomUUID());
        dto.setCreatedDate(LocalDateTime.now());
        Notification notification = mapper.map(dto, Notification.class);
        Notification saved = notificationRepository.save(notification);
        System.out.println(saved);
        return mapper.map(saved, NotificationDto.class);
    }

    @Override
    public NotificationDto getNotificationById(UUID id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
        return mapper.map(notification, NotificationDto.class);
    }

    @Override
    public List<NotificationDto> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notification -> mapper.map(notification, NotificationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto updateNotification(UUID id, NotificationDto dto) {
        Notification existingNotification = notificationRepository.findById(id).orElseThrow();

        for (Field field : dto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(dto);
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
    public void deleteNotification(UUID id) {
        Notification notification = notificationRepository.findById(id).orElseThrow();
        notificationRepository.delete(notification);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
