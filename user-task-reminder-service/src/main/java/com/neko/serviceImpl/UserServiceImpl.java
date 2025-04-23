package com.neko.serviceImpl;

import com.neko.dto.UserDto;
import com.neko.entity.User;
import com.neko.exceptions.ErrorCode.ErrorCode;
import com.neko.exceptions.UserTaskReminderException;
import com.neko.repositories.UserRepository;
import com.neko.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDto create(UserDto user) {
        user.setId(UUID.randomUUID());
        user.setCreatedDate(LocalDateTime.now());
        User savedUser = userRepository.save(mapper.map(user,User.class));
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto get(UUID id) {
        return mapper.map(userRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.USER_NOT_FOUND, id)), UserDto.class);
    }

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(UUID id, UserDto user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.USER_NOT_FOUND, id));

        for(Field field: user.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(user);
                if(Objects.nonNull(value)) {
                    Field entityField = existingUser.getClass().getDeclaredField(field.getName());
                    entityField.setAccessible(true);
                    entityField.set(existingUser, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        return mapper.map(userRepository.save(existingUser), UserDto.class);
    }

    @Override
    public void delete(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.USER_NOT_FOUND, id));
        userRepository.delete(user);
    }
}
